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
<div class="wrap">
	<div class="regist-form">
		<div class="container">
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>서브 아이디</b></label>
					<div class="row mb-3">
						<div class="col">
							<input type="text" class="form-control" id="sub-id" name="sub-id" placeholder="@Sub-ID">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>템플릿 선택</b></label>
					<div class="row mb-3">
						<div class="col">
							<select id="template-select" class="form-select" onchange="template(event);"></select>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col">
							<input type="text" id="template-code" class="form-control" disabled="disabled" placeholder="@Template-Code" style="display: none;">
							<textarea class="form-control" id="template-msg" style="height: 300px;" disabled="disabled" placeholder="Template-Message"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="row mb-3">
						<div class="col text-center">
							<button class="btn btn-primary">등록</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript">
	window.onload = function(){
		getTemplate();
	};
	
	function getTemplate(){
		$.ajax({
			type:"post",
			url:"/ajax/templates",
			success:function(result){
				setTeamplate(result.templateList);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}		
		});
	}
	function setTeamplate(templateList){
		let select = document.querySelector("#template-select");
		
		let start = document.createElement("option");
		start.setAttribute("hidden", "hidden");
		start.setAttribute("selected", "selected");
		start.innerHTML="Select Template";
		select.appendChild(start);
		
		for(let i=0;i<templateList.length;i++){
			let option = document.createElement("option");
			
			option.setAttribute("value", templateList[i].msg);
			option.innerHTML=templateList[i].template_code;
			select.appendChild(option);
		}
	}
	function template(){
		let select = document.querySelector("#template-select");
		
		let templateCode = document.querySelector("#template-code");
		let templateMsg = document.querySelector("#template-msg");
		
		let option = select.options[select.selectedIndex];
		let text = option.text;
		let value = option.value;
		
		templateCode.value = null;
		templateCode.value = text;
		templateCode.setAttribute("value", text);
		templateCode.setAttribute("disabled", "disabled");

		templateMsg.value = null;
		templateMsg.value = value;
		templateMsg.setAttribute("value", value);
		templateMsg.setAttribute("disabled", "disabled");
	}
</script>
</html>