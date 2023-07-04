<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css?ver=1.1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css?ver=1.1">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/template_list.js?ver=1.1"></script>
<script src="${pageContext.request.contextPath}/resources/js/modal.js?ver=1.1"></script>
</head>
<body>
<div class="wrap">
	<div id="phone">
		<div class="row">
			<div class="col">
				<label class="form-label">발신자 목록</label>
			</div>
			<div class="col-8">
				
			</div>
			<div class="col">
				<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#phoneModal">발신자 등록</button>
			</div>
		</div>
		<div id="phoneList" class="row list">
			
		</div>
	</div>
	<hr class="border border-dark border-1 opacity-100">
	
	<div id="channel">
		<div class="row">
			<div class="col">
				<label class="form-label">채널 목록</label>
			</div>
			<div class="col-8">
				
			</div>
			<div class="col">
				<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#channelModal">채널 등록</button>
			</div>
		</div>
		<div id="channelList" class="row list">
			
		</div>		
	</div>
	<hr class="border border-dark border-1 opacity-100">
	
	<div id="template">
		<div class="row">
			<div class="col">
				<label class="form-label">템플릿 목록</label>
			</div>
			<div class="col-8">
				
			</div>
			<div class="col">
				<button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#templateModal" onclick="templateBtn();">템플릿 등록</button>
			</div>
		</div>
		<div id="templateList" class="row list">
			
		</div>		
	</div>
	<hr class="border border-dark border-1 opacity-100">
	
	<jsp:include page="../modal/phone-modal.jsp"></jsp:include>
	<jsp:include page="../modal/channel-modal.jsp"></jsp:include>
	<jsp:include page="../modal/template-modal.jsp"></jsp:include>
	<jsp:include page="../modal/msg-modal.jsp"></jsp:include>
</div>

<script type="text/javascript">
	window.onload = function(){		
		showButton('phone');
		showButton('channel');
		showButton('template');
	};
	
	function regButton(value){
		regProc(value);
		//showButton(value);
		//clearBtn(value);
		location.reload();
	}
	
	function regProc(value){
		let url;
		let jsonData;

		if(value=='phone'){
			const object = new Object();
			const phone = document.getElementById("phone-num").value;
			const comment = document.getElementById("phone-comment").value;
			
			object.phone = phone;
			object.comment = comment;
			jsonData = JSON.stringify(object);
			
			url = "/api/v1/phone.do";
		}
		else if(value=='channel'){
			const object = new Object();
			const channelName = document.getElementById("channel-name").value;
			const senderKey = document.getElementById("channel-key").value;
			
			object.channel_name = channelName;
			object.sender_key = senderKey;
			
			jsonData = JSON.stringify(object);
			
			url = "/api/v1/channel.do";
		}
		else if(value=='template'){
			const object = new Object();
			
			object.sub_id = document.getElementById("sub-select").value;
			object.template_code = document.getElementById("template-select").value;
			object.channel_name = document.getElementById("channel-select").value;
			object.phone = document.getElementById("phone-select").value;
			object.msg = document.getElementById("msg-select").value;
			object.comment = document.getElementById("comment-select").value;
			
			jsonData = JSON.stringify(object);
			
			url = "/api/v1/template.do";
		}
		else{
			return;
		}
		
		$.ajax({
			type:"post",
			url:url,
			dataType:"json",
			contentType:"application/json",
			data:jsonData,
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\", \"value\": \"regProc(" + value + ")\"}");				
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	}
	
	function showButton(value){
		let url;
		
		if(value=='phone'){
			url = "/api/v1/phone.do";
		}
		else if(value=='channel'){
			url = "/api/v1/channel.do";
		}
		else if(value=='template'){
			url = "/api/v1/template.do";
		}
		else{
			return;
		}
		
		$.ajax({
			type:"get",
			url:url,
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\", \"value\": \"showButton(" + value + ")\"}");
				const datas = result.datas;
				if(value=='phone'){
					setPhoneList(datas);
				}
				else if(value=='channel'){
					setChannelList(datas);
				}
				else if(value=='template'){
					setTemplateList(datas);
				}
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	};
	
	function templateBtn(){
		$.ajax({
			type:"get",
			url:"/api/v1/phone.do",
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\"}");
				const datas = result.datas;
				selectPhone(datas);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
		
		$.ajax({
			type:"get",
			url:"/api/v1/channel.do",
			success:function(result){
				console.log("{\"status\": " + result.status + ", \"timestamp\": \"" + result.timestamp + "\"}");
				const datas = result.datas;
				selectChannel(datas);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	};
	
</script>
</body>
</html>