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
							<input type="text" class="form-control" id="channel" name="channel" disabled="disabled" placeholder="@채널">
						</div>
						<div class="col-9">
							<input type="text" class="form-control" id="sender-key" name="sender-key" disabled="disabled" placeholder="센더키">
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="formGroupExampleInput" class="form-label"><b>다음</b></label>
					<div class="row mb-3">
						<div class="col">
							1
						</div>
					</div>
					<div class="row mb-3">
						<div class="col-3">
							2
						</div>
						<div class="col-9">
							3
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	window.onload = function(){
		console.log("hello");
		getChannelList();
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
	}
	
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
</script>
</body>
</html>