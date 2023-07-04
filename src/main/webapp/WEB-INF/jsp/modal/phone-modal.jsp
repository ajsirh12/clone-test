<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- Modal phone -->
<div class="modal" id="phoneModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">발신자 등록</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>발신번호*</b></label>
					<input type="text" class="form-control" id="phone-num" placeholder="핸드폰번호 11자리" maxlength="11" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');">
				</div>
				<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>comment</b></label>
					<textarea type="text" class="form-control" id="phone-comment" placeholder="comment" style="height: 200px; resize: none;"></textarea> 
				</div>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-toggle="modal" data-bs-target="#phoneConfirm" onclick="nextBtn('phone')">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('phone')">닫기</button>
			</div>
		</div>
	</div>
</div>

<!-- Modal phone confirm -->
<div class="modal" id="phoneConfirm" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">확인</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body text-center">
				<label for="formGroupExampleInput" class="form-label"><b>발신자 번호 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="phone-confirm"></b></label>
				<br>
				<label for="formGroupExampleInput" class="form-label"><b>부가설명 : </b></label>
				<label for="formGroupExampleInput" class="form-label"><b id="comment-confirm"></b></label>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="regBtn" class="btn btn-primary btn-lg" data-bs-dismiss="modal" onclick="regButton('phone');">등록</button>
			  	<button type="button" id="closeBtn" class="btn btn-dark btn-lg" data-bs-toggle="modal" data-bs-target="#phoneModal">취소</button>
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal" onclick="clearBtn('phone')">닫기</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
