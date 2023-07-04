<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- Modal channel -->
<div class="modal" id="channelModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">채널 등록</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
			  	<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>채널명*</b></label>
					<input type="text" class="form-control" id="channel-name" placeholder="channel-name">
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>키*</b></label>
					<input type="text" class="form-control" id="channel-key" placeholder="sender-key">
				</div>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#channelConfirm" onclick="nextBtn('channel')">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('channel')">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal channel confirm -->
<div class="modal" id="channelConfirm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">확인</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
				<label for="formGroupExampleInput" class="form-label"><b>채널명 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="name-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>키 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="key-confirm"></b></label>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-dismiss="modal" onclick="regButton('channel');">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-dark btn-lg" data-bs-toggle="modal" data-bs-target="#channelModal">취소</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('channel')">닫기</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
