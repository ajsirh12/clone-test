<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="wrap">
	<div id="login" class="container">
		<div class="row">
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"><b>아이디</b></label>
				<input type="text" class="form-control" id="user" placeholder="ID">
			</div>
			<div class="mb-3">
				<label for="formGroupExampleInput" class="form-label"><b>비밀번호</b></label>
				<input type="password" class="form-control" id="pwd" placeholder="PASSWORD" onkeypress="if(window.event.keyCode==13){doneBtn();}">
			</div>
			<div class="mb-3">
				<a id="doneBtn" onclick="doneBtn();"><button class="btn btn-primary">로그인</button></a>
			</div>
		</div>
	</div>
</div>
	
<script type="text/javascript">
	function doneBtn(){
		const user = document.getElementById("user").value;
		const pwd = document.getElementById("pwd").value;
		
		$.ajax({
			type:"post",
			url:"/api/v1/login.do",
			data:{user:user, pwd:pwd},
			success:function(result){
				console.log(result);
				location.href="/main";
			},
			error:function(request, status, error){
				console.log(request.responseText);
				console.log(error);
				alert("아이디 혹은 비밀번호가 일치하지 않습니다.");
				removeTxt();
			}
		});
	};
	
	function removeTxt(){
		let id = document.getElementById("user");
		let pwd = document.getElementById("pwd");
		
		id.value = null;
		pwd.value = null;
	}
</script>
</body>
</html>