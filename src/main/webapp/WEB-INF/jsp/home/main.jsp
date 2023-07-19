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
	<div id="menu" class="container">
		<div class="row">
			<div class="col mb-3">
				<label for="formGroupExampleInput" class="form-label"><button class="btn btn-primary" onclick="doButton(event);" value="001">템플릿 등록</button></label>
			</div>
		</div>
		<div class="row">
			<div class="col mb-3">
				<label for="formGroupExampleInput" class="form-label"><button class="btn btn-primary" onclick="doButton(event);" value="003">서브 아이디 등록</button></label>
			</div>
		</div>
		<div class="row">
			<div class="col mb-3">
				<label for="formGroupExampleInput" class="form-label"><button class="btn btn-primary" onclick="doButton(event);" value="002">전송 통계</button></label>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	function doButton(event){
		const val = event.target.value;
		
		if(val == 001){
			location.href="/admin/regist";
		}
		else if(val == 002){
			location.href="/admin/statistic";
		}
		else if(val == 003){
			location.href="/admin/regist/sub";
		}
	};
</script>
</body>
</html>