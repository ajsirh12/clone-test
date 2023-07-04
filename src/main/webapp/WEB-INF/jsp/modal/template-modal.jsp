<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- Modal template -->
<div class="modal" id="templateModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">템플릿 등록</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
			  	<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>api 아이디*</b></label>
					<input type="text" class="form-control" id="sub-select" placeholder="api ID">
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>템플릿 코드*</b></label>
					<input type="text" class="form-control" id="template-select" placeholder="Template Code">
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>채널명*</b></label>
					<select class="form-select" aria-label="channel-select" id="channel-select">
						
					</select>
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>발신번호*</b></label>
					<select class="form-select" aria-label="phone-select" id="phone-select">
						
					</select>
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>템플릿 메시지*</b></label>
					<textarea type="text" class="form-control" id="msg-select" placeholder="Template Message" style="height: 300px; resize: none;"></textarea>
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>설명*</b></label>
					<textarea type="text" class="form-control" id="comment-select" placeholder="comment" style="height: 300px; resize: none;"></textarea>
				</div>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#templateConfirm" onclick="nextBtn('template')">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('template')">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal channel confirm -->
<div class="modal" id="templateConfirm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">확인</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
				<label for="formGroupExampleInput" class="form-label"><b>채널명 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="api-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>템플릿코드 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="template-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>채널명 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="channel-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>전화번호 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="num-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>내용 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="msg-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>설명 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="comm-confirm"></b></label>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-dismiss="modal" onclick="regButton('template');">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-dark btn-lg" data-bs-toggle="modal" data-bs-target="#templateModal">취소</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('phone')">닫기</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
