<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 파라미터 읽기
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	// 콘솔에 읽은 파라미터 출력
	System.out.println(id);
	System.out.println(pw);
	
	// 결과 페이지로 이동
	
	/*// 포워딩으로 결과 페이지로 이동 : URL 변경 X
	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request,response);*/
	
	// 리다이렉트로 이동 - URL 변경
	// response.sendRedirect("result.jsp");
	
	// 리퀘스트에 저장 - 소멸
	request.setAttribute("data1","리퀘스트");
	// 세션에 저장 - 유지
	session.setAttribute("data2","세션");

	RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
	dispatcher.forward(request,response);
	
	
%>
</body>
</html>