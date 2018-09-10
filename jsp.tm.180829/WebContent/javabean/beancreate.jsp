<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="member" class="vo.Member" scope="request"></jsp:useBean>
    <%
    	member.setId("ITeaBang");
    	member.setPassword("1234");
    	member.setName("관리자");
    	member.setPhone("01012345678");
    	member.setAddress("경기도 부천시");
    %>
    <!-- 포워딩 -->
    <jsp:forward page="beanuse.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>