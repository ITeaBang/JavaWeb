<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 이전 페이지에서 만든 bean 가져오기 -->
    <jsp:useBean id="member" class="vo.Member" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("<p> ID : " + member.getId() + "</p>");
	out.println("<p> PW : " + member.getPassword() + "</p>");
	out.println("<p> NAME : " + member.getName() + "</p>");
	out.println("<p> PHONE : " + member.getPhone() + "</p>");
	out.println("<p> ADDRESS : " + member.getAddress() + "</p>");
%>
</body>
</html>