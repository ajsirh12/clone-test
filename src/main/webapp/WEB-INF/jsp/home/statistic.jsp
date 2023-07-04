<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css?ver=1.1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chart-style.css?ver=1.21">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.3/Chart.bundle.min.js"></script>
</head>
<body>
<div class="wrap">
	<div class="container">
		<div class="row">
			<div class="col">
				<select id="selectBox" class="form-select" aria-label="Default select example" onchange="changeEvent()">
					<option selected="selected" value="total">전체</option>
				</select>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-6 chart-div">
				<div class="row text-center">
					<div class="col">
						알림톡
					</div>
				</div>
				<div class="row">
					<div id="stat-div">
						<!-- <canvas id="statPie" style="width: 80%; margin-left: 10%; margin-right: 10%;"></canvas> -->
					</div>	
				</div>
				<div class="row">
					<div class="col" id="statLegend">
						
					</div>
				</div>
			</div>
			<div class="col-6 chart-div">
				<div class="row text-center">
					<div class="col">
						LMS
					</div>
				</div>
				<div class="row">
					<div id="lms-div">
						<!-- <canvas id="lmsPie" style="width: 80%; margin-left: 10%; margin-right: 10%;"></canvas> -->
					</div>	
				</div>
				<div class="row">
					<div class="col" id="lmsLegend">
					
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	window.onload = function(){
		getStauts();
		getSubList();
	};
	
	function getSubList(){
		$.ajax({
			type:"get",
			url:"api/v1/statistics/sub-list.do",
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\", \"function\":\"getSubList()\"}");
				setSubList(result.datas);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	};
	
	function setSubList(datas){
		let select = document.getElementById("selectBox");
		
		for(var idx=0;idx<datas.length;idx++){
			let option = document.createElement("option");
			
			option.setAttribute("value", datas[idx].sub_id);
			option.innerHTML=datas[idx].comment;
			
			select.appendChild(option);
		}
	}
	
	function getStauts(){
		$.ajax({
			type:"get",
			url:"/api/v1/statistics/total.do",
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\", \"function\":\"getStatus()\"}");
				setPieChart(result.codeList, "statPie", "statLegend", "stat-div");
				setPieChart(result.failbackList, "lmsPie", "lmsLegend", "lms-div");
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
				
				if(request.responseJSON.status == 401){
					alert("세션이 만료되었습니다.");
					location.href="/login";
				}
			}	
		});
	};
	
	function getStautsSub(value){
		$.ajax({
			type:"get",
			url:"/api/v1/statistics/stat.do?param=" + value,
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\", \"function\":\"getStatus(" + value + ")\"}");
				setPieChart(result.codeList, "statPie", "statLegend", "stat-div");
				setPieChart(result.failbackList, "lmsPie", "lmsLegend", "lms-div");
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
				if(request.responseJSON.status == 401){
					alert("세션이 만료되었습니다.");
					location.href="/login";
				}
			}	
		});
	};
	
	function setPieChart(dataList, chartId, legendId, divId){
		let labels= [];
		let datas = [];
		let bgColors = [];
		
		let legend = document.getElementById(legendId);
		let ul = document.createElement("ul");
		
		let div = document.getElementById(divId);
		let canvas = document.createElement("canvas");
		canvas.setAttribute("id", chartId);
		canvas.setAttribute("style", "width:80%; margin-left:10%; margin-right:10%;");
		div.appendChild(canvas);
		
		for(var idx=0; idx<dataList.length; idx++){
			if(dataList[idx].code == null){
				labels[idx] = 'Unknown';	
			}
			else{
				labels[idx] = dataList[idx].code;	
			}
			datas[idx] = dataList[idx].count;
			
			var r = Math.floor(Math.random() * (255 + 1))
			var g = Math.floor(Math.random() * (255 + 1))
			var b = Math.floor(Math.random() * (255 + 1))
			var color = 'rgba(' + r + ',' + g +',' + b + ',0.6)'; 
			
			bgColors[idx] = color;
			
			let li = document.createElement("li");
			let span = document.createElement("span");
			
			span.setAttribute("style", "background-color:" + bgColors[idx] + ";");
			span.setAttribute("class", "custom-span");
			li.setAttribute("data-index", idx);
			li.appendChild(span);
			li.innerHTML +=  labels[idx];
			
			ul.appendChild(li);
		}
		
		legend.appendChild(ul);
		
		let pieData = {
				labels: labels,
				datasets: [{
					data: datas,
					backgroundColor: bgColors
				}]
		};
		
		let ctx = canvas.getContext('2d');
		
		window.pieChart = new Chart(ctx, {
			type: 'pie',
			data: pieData,
			options:{
				responsive:false,
				legend:false
			}
		});
	};
	
	function changeEvent(){
		var value = document.getElementById("selectBox").value;
		
		let statDiv = document.getElementById("stat-div");
		let lmsDiv = document.getElementById("lms-div");
		let statLegend = document.getElementById("statLegend");
		let lmsLegned = document.getElementById("lmsLegend");
		
		removeAllChild(statDiv);
		removeAllChild(lmsDiv);
		removeAllChild(statLegend);
		removeAllChild(lmsLegend);
		
		if(value == 'total'){
			getStauts();	
		}
		else{
			getStautsSub(value);	
		}
	};
	
	function removeAllChild(parents){
		while(parents.hasChildNodes()){
			parents.removeChild(parents.firstChild);
		}
	};
	
</script>
</body>
</html>