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

<style type="text/css">
	.input-group-text{
		width: 30%;
	}
	.mb-1{
		font-size: 0.9em;
	}
</style>
</head>
<body>
<div class="wrap" style="font-size: 0.9em;">
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

<div class="modal fade" id="infoModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #252525;">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">상세 정보</h1>
					<button id="modalClose" data-bs-dismiss="modal" hidden="hidden"></button>
				</div>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col">
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput" class="form-label"><b>채널 정보</b></label>
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">채널명</span>
								<input type="text" class="form-control" id="channelName" readonly="readonly">
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">채널키</span>
								<input type="text" class="form-control" id="senderKey" readonly="readonly">
							</div>
						</div>
						
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput" class="form-label"><b>발송자 정보</b></label>
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">전화번호</span>
								<select class="form-select" id="phone-select">
									
								</select>
							</div>
						</div>
						
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput" class="form-label"><b>템플릿 정보</b></label>
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">템플릿 코드</span>
								<input type="text" class="form-control" id="templateCode" readonly="readonly">
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">템플릿 메시지</span>
								<textarea class="form-control" id="templateMsg" readonly="readonly" style="height: 200px;"></textarea>
							</div>
						</div>
						<div class="row mb-1">
							<div class="col input-group">
								<span class="input-group-text">템플릿 설명</span>
								<textarea class="form-control" id="comment" readonly="readonly" style="height: 100px;"></textarea>
							</div>
						</div>
						
						<div class="row">
							<div class="col">
								<label for="formGroupExampleInput" class="form-label"><b>버튼 정보</b></label>
							</div>
						</div>
						<div class="row mb-1" id="buttonDiv">
							
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer" style="display: block;">
				<div class="row">
					<div class="col-4">
					</div>
					<div class="col-4 btn-group">
						<button class="btn btn-outline-primary" onclick="updateInfo();">수정</button>
						<button class="btn btn-outline-danger" onclick="closeModal();">닫기</button>
					</div>
					<div class="col-4">
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	window.onload = function(){
		getTemplate();
		getPhoneList();
	};

	function closeModal(){
		let close = document.querySelector("#modalClose");
		console.log("close");
		close.click();
	}
	
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
			btn.setAttribute("data-bs-toggle", "modal");
			btn.setAttribute("data-bs-target", "#infoModal");
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
		
		$.ajax({
			type:"post",
			url:"/ajax/manage/template/detail",
			data:{templateCode:event.target.value},
			success:function(result){
				setInfo(result);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}
		});
	}
	function setInfo(result){
		let detail = result.tempDetail;
		
		let channelName = document.querySelector("#channelName");
		let senderKey = document.querySelector("#senderKey");
		let templateCode = document.querySelector("#templateCode");
		let templateMsg = document.querySelector("#templateMsg");
		let phoneSelect = document.querySelector("#phone-select");
		let comment = document.querySelector("#comment");
		
		channelName.value = detail.channel_name;
		senderKey.value = detail.sender_key;
		templateCode.value = detail.template_code;
		templateMsg.value = detail.msg;
		phoneSelect.value = detail.phone;
		comment.value = detail.comment;
		
		let btnDiv = document.querySelector("#buttonDiv");
		let btnList = result.buttonList;
		
	}
	
	function updateInfo(){
		console.log("update");
		alert("hello");
		closeModal();
	}
	
	function getPhoneList(){
		console.log("phoneList");
		
		$.ajax({
			type:"post",
			url:"/ajax/phones",
			success:function(result){
				setPhoneList(result.phoneList);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}		
		});
	};
	function setPhoneList(result){
		let phoneSelect = document.querySelector("#phone-select");
		
		let optionStart = document.createElement("option");
		optionStart.setAttribute("hidden", "hidden");
		optionStart.setAttribute("selected", "selected");
		optionStart.innerHTML = "Select Phone";
		phoneSelect.appendChild(optionStart);
		
		for(let i=0; i<result.length; i++){
			let option = document.createElement("option");
			option.setAttribute("value", result[i].phone);
			option.innerHTML = result[i].phone;
			phoneSelect.appendChild(option);
		}
	};
</script>
</body>
</html>