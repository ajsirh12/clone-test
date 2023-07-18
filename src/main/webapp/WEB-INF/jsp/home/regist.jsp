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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/modal.css?ver=1.1">

<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="wrap">
	<div class="regist-form">
		<div class="container">
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>채널선택</b></label>
					<div class="row mb-3">
						<div class="col">
							<select id="channel-select" class="form-select" onchange="channel();">
							</select>
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-3">
							<input type="text" class="form-control" id="channel" name="channel" disabled="disabled" placeholder="@Channel Name">
						</div>
						<div class="col-9">
							<input type="text" class="form-control" id="sender-key" name="sender-key" disabled="disabled" placeholder="Sender Key">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>발신자번호</b></label>
					<div class="row mb-3">
						<div class="col">
							<select id="phone-select" class="form-select">
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>템플릿</b></label>
					<div class="row mb-3">
						<div class="col">
							<input type="text" class="form-control" id="template-code" name="template-code" placeholder="Template Code">
						</div>
					</div>
					<div class="row mb-3">
						<div class="col">
							<input type="text" class="form-control" id="lms-title" name="lms-title" placeholder="LMS Title">
						</div>
					</div>
					<div class="row mb-3">
						<div class="col">
							<textarea class="form-control" id="template-msg" name="template-msg" placeholder="Template Message" style="height: 200px;"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col" id="btn-div">
					<label for="formGroupExampleInput" class="form-label"><b>버튼 </b><button class="btn btn-outline-primary btn-sm" onclick="addBtn();"> + </button></label>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>추가 설명</b></label>
					<div class="row mb-3">
						<div class="col">
							<textarea class="form-control" id="comment" name="comment" placeholder="Comment" style="height: 200px;"></textarea>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col text-center">
					<button class="btn btn-primary" onclick="regist();">등록</button>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	let btnList = new Array();
	
	window.onload = function(){
		getChannelList();
		getPhoneList();
		getBtnList();
	};

	function regist(){
		let jsonData;
		let object = new Object();
		
		let channel = document.querySelector("#channel");
		let senderKey = document.querySelector("#sender-key");
		let phone = document.querySelector("#phone-select");
		let templateCode = document.querySelector("#template-code");
		let templateMsg = document.querySelector("#template-msg");
		let lmsTitle = document.querySelector("#lms-title");
		let comment = document.querySelector("#comment");
		
		let btnList = new Array();
		let btnTitle = document.querySelectorAll(".btn-title");
		let btnMsg = document.querySelectorAll(".btn-msg");
		let status = document.querySelectorAll(".status");
		for(let i=0;i<btnTitle.length; i++){
			let temp = {'name':btnTitle[i].value, 'url':btnMsg[i].value, 'status':status[i].value};
			btnList.push(temp);
		}
		
		object.channelName = channel.value;
		object.senderKey = senderKey.value;
		object.phone = phone.value;
		object.templateCode = templateCode.value;
		object.lmsTitle= lmsTitle.value;
		object.msg = templateMsg.value;
		object.comment = comment.value;
		object.btnList = btnList;
		jsonData = JSON.stringify(object);
		
		$.ajax({
			type:"post",
			url:"/ajax/regist",
			contentType: "application/json",
			data:jsonData,
			success:function(result){
				// location.href="/admin/regist";
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}		
		});
	};
	
	function getChannelList(){
		console.log("channelList");
		
		let jsonData;
		let object = new Object();
		
		let channel = document.querySelector("#channel");
		let senderKey = document.querySelector("#sender-key");
		
		object.channel = channel;
		object.senderkey = senderKey;
		jsonData = JSON.stringify(object);
		
		$.ajax({
			type:"post",
			url:"/ajax/channels",
			data:jsonData,
			success:function(result){
				setChannelList(result.channelList);
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}		
		});
	};
	function setChannelList(result){
		let channelSelect = document.querySelector("#channel-select");
		
		let optionStart = document.createElement("option");
		optionStart.setAttribute("hidden", "hidden");
		optionStart.setAttribute("selected", "selected");
		optionStart.innerHTML = "Select Channel";
		channelSelect.appendChild(optionStart);
		
		for(let i=0; i<result.length; i++){
			let option = document.createElement("option");
			option.setAttribute("value", result[i].sender_key);
			option.innerHTML = result[i].channel_name;
			channelSelect.appendChild(option);
		}
		let optionNew = document.createElement("option");
		optionNew.setAttribute("value", "new");
		optionNew.innerHTML = "신규 채널"
		channelSelect.appendChild(optionNew);
	};
	
	function channel(){
		let channelSelect = document.querySelector("#channel-select");
		
		let channel = document.querySelector("#channel");
		let senderKey = document.querySelector("#sender-key");
		
		let option = channelSelect.options[channelSelect.selectedIndex];
		let text = option.text;
		let value = option.value;
		
		if(value == "new"){
			channel.value = null;
			channel.setAttribute("value", "");
			channel.removeAttribute("disabled");
			
			senderKey.value = null;
			senderKey.setAttribute("value", "");
			senderKey.removeAttribute("disabled");
		}
		else{
			channel.value = null;
			channel.value = text;
			channel.setAttribute("value", text);
			channel.setAttribute("disabled", "disabled");

			senderKey.value = null;
			senderKey.value = value;
			senderKey.setAttribute("value", value);
			senderKey.setAttribute("disabled", "disabled");
		}
	};
	
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
	
	function addBtn(){
		let btnDiv = document.querySelector("#btn-div");
		
		let row20 = document.createElement("div");
		row20.setAttribute("class", "row mb-3 rowrow");
		
		let col20 = document.createElement("div");
		col20.setAttribute("class", "col");
		
		let row10 = document.createElement("div");
		row10.setAttribute("class", "row mb-3");
		
		let col10 = document.createElement("div");
		col10.setAttribute("class", "col");
		let select = setBtnBox();
		
		col10.appendChild(select);
		row10.appendChild(col10);
		btnDiv.appendChild(row10);
		
		let row00 = document.createElement("div");
		row00.setAttribute("class", "row mb-3");
		
		let col01 = document.createElement("div");
		col01.setAttribute("class", "col-3");
		
		let title = document.createElement("input");
		title.setAttribute("class", "form-control btn-title");
		title.setAttribute("type", "text");
		title.setAttribute("name", "btn-title");
		title.setAttribute("placeholder", "Button Title");
		title.setAttribute("disabled", "disabled");
		col01.appendChild(title);
		
		let col02 = document.createElement("div");
		col02.setAttribute("class", "col-8");
		
		let msg = document.createElement("input");
		msg.setAttribute("class", "form-control btn-msg");
		msg.setAttribute("type", "text");
		msg.setAttribute("name", "btn-msg");
		msg.setAttribute("placeholder", "Button Message");
		msg.setAttribute("disabled", "disabled");
		col02.appendChild(msg);
		
		let col03 = document.createElement("div");
		col03.setAttribute("class", "col-1");
		let remove = document.createElement("button");
		remove.setAttribute("class", "btn btn-outline-danger");
		remove.setAttribute("onclick", "removeBtn(event)");
		remove.innerHTML = "-";
		col03.appendChild(remove);
		
		let hidden = document.createElement("input");
		hidden.setAttribute("type", "text");
		hidden.setAttribute("style", "display: none;");
		hidden.setAttribute("class", "status");
		
		row00.appendChild(col01);
		row00.appendChild(col02);
		row00.appendChild(col03);
		row00.appendChild(hidden);
		
		col20.appendChild(row10);
		col20.appendChild(row00);
		
		row20.appendChild(col20);
		
		btnDiv.appendChild(row20);
	};
	function getBtnList(){
		console.log("btnList");
		
		$.ajax({
			type:"post",
			url:"/ajax/buttons",
			success:function(result){
				btnList = result.btnList;
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
			}		
		});
	};
	function setBtnBox(){
		let select = document.createElement("select");
		select.setAttribute("class", "form-select");
		select.setAttribute("onchange", "button(event)");
		
		let optionStart = document.createElement("option");
		optionStart.setAttribute("hidden", "hidden");
		optionStart.setAttribute("selected", "selected");
		optionStart.innerHTML = "Select Button";
		select.appendChild(optionStart);
		
		for(let i=0; i<btnList.length; i++){
			let option = document.createElement("option");
			option.setAttribute("id", btnList[i].name);
			option.setAttribute("value", btnList[i].url_mobile);
			option.innerHTML = btnList[i].name;
			select.appendChild(option);
		}
		
		let optionNew = document.createElement("option");
		optionNew.setAttribute("value", "new");
		optionNew.innerHTML = "신규 버튼"
		select.appendChild(optionNew);
		
		return select;
	};
	function button(event) {
		const selectedValue = event.target.value;
		const selectedId = event.target.options[event.target.selectedIndex].id;
		
		const btnTitleInput = event.target.closest(".row").nextElementSibling.querySelector(".btn-title");
		const btnMsgInput = event.target.closest(".row").nextElementSibling.querySelector(".btn-msg");
		const hiddenInput = event.target.closest(".row").nextElementSibling.querySelector(".status");
		
		if(selectedValue == "new"){
			btnTitleInput.value = null;
			btnTitleInput.setAttribute("value", "");
			btnTitleInput.removeAttribute("disabled");
			
			btnMsgInput.value = null;
			btnMsgInput.setAttribute("value", "");
			btnMsgInput.removeAttribute("disabled");
			
			hiddenInput.value = "new";
			hiddenInput.setAttribute("value", "new");
		}
		else{
			btnTitleInput.value = null;
			btnTitleInput.value = selectedId;
			btnTitleInput.setAttribute("value", selectedId);
			btnTitleInput.setAttribute("disabled", "disabled");

			btnMsgInput.value = null;
			btnMsgInput.value = selectedValue;
			btnMsgInput.setAttribute("value", selectedValue);
			btnMsgInput.setAttribute("disabled", "disabled");
			
			hiddenInput.value = null;
			hiddenInput.setAttribute("value", "");
		}
	};
	function removeBtn(event){
		let row20 = event.target.closest(".rowrow");
		if(row20){
			row20.remove();
		}
	}
</script>
</body>
</html>