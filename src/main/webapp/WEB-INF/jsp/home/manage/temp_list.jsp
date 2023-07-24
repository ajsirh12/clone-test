<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css?ver=1.2">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="wrap" style="font-size: 0.9em;">
	<div class="regist-form">
		<div class="container">
			<div class="row">
				<div class="col">
					<table class="table text-center table-striped align-middle">
						<thead>
							<tr>
								<th class="col-1">No.</th>
								<th class="col-3">템플릿 코드</th>
								<th class="col-3">채널</th>
								<th class="col-3">설명</th>
								<th class="col-2">상세보기</th>
							</tr>
						</thead>
						<tbody id="template-list">
							
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>



<script type="text/javascript">
	window.onload = function(){
		getTemplate();
	};

	function getTemplate(){
		$.ajax({
			type:"post",
			url:"/ajax/manage/template/list",
			success:function(result){
				setTemplateList(result.templateList);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	};
	function setTemplateList(result){
		let tbody = document.querySelector("#template-list");
		
		for(let i=0;i<result.length;i++){
			let tr = document.createElement("tr");
			
			let td00 = document.createElement("td");
			let td01 = document.createElement("td");
			let td02 = document.createElement("td");
			let td03 = document.createElement("td");
			let td04 = document.createElement("td");
			
			td00.innerHTML = i + 1;
			td01.innerHTML = result[i].template_code;
			td02.innerHTML = result[i].channel_name;
			td03.innerHTML = result[i].comment;
			
			let btn = document.createElement("button");
			btn.setAttribute("class", "btn btn-primary btn-sm");
			btn.setAttribute("onclick", "infoView(event);");
			btn.setAttribute("value", result[i].template_code);
			btn.innerHTML = "상세";
			td04.appendChild(btn);
			
			tr.appendChild(td00);
			tr.appendChild(td01);
			tr.appendChild(td02);
			tr.appendChild(td03);
			tr.appendChild(td04);
			tbody.appendChild(tr);
		}
	}
	
	function infoView(event){
		console.log(event.target.value);
	}
</script>
</body>
</html>