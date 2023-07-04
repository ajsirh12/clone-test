<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<!-- Modal msg -->
<div class="modal" id="msgModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container text-center">
					<h1 class="modal-title fs-5" id="modalTitle" style="color: #ffffff">채널 등록</h1>
				</div>
			</div>
			<div id="modalInfo" class="modal-body">
			  	<div class="mb-3 div_style">
					<label for="formGroupExampleInput" class="form-label"><b>템플릿 내용</b></label>
					<br>
					<label for="formGroupExampleInput" class="form-label" id="tmp-msg"></label>
				</div>
			</div>
			<div class="modal-footer" style="margin: 0 auto;">
			  	<button type="button" id="closeBtn" class="btn btn-danger btn-lg" data-bs-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
</script>
</body>
</html>
