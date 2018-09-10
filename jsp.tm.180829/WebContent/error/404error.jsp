<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404에러 페이지</title>
</head>
<body>
	<p>5초 후 메인 페이지로 이동합니다.</p>
	<h3>404. That's an error.</h3>
	
The requested URL /search was not found on this server.
</body>
<script>
	setTimeout(fuction(){
			location.href="javabean/beancreate.jsp"		
	},5000)
</script>
</html>