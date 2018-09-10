<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
	<%
		// 세션을 초기화 - id가 지워지면서 로그아웃된 효과 발생
		session.invalidate();
	%>
	성공적으로 로그아웃되었습니다.<br />
	<p>5초 후에 메인 페이지로 이동합니다.</p>
	<script>
		// 5초 후에 동작하는 타이머를 이용해서 main.jsp로 이동
		setTimeout(function(){
			location.href='main.jsp';
		}, 5000);
	</script>
</body>
</html>