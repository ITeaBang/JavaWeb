<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*//데이터 저장
	request.setAttribute("id","iteabang");
	request.setAttribute("score",80);*/

	//결과 페이지로 포워딩
	/*RequestDispatcher dispatcher = 
		request.getRequestDispatcher(
			"attrdisplay.jsp");
	dispatcher.forward(request, response);*/
	
	// 결과 페이지로 리다이렉트 - request의 데이터는 전달 불가
	session.setAttribute("id","iteabang");
	session.setAttribute("score",70);
	response.sendRedirect("attrdisplay.jsp");
%>