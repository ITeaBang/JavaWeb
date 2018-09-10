<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
		// post 방식에서의 파라미터 인코딩 처리
		request.setCharacterEncoding("utf-8");

		// login.jsp에서 전송해 준 파라미터 읽기
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		if (id.equals("system") && pw.equals("1234")) {
			// out.println("로그인 성공");
			
			// 로그인 정보를 세션에 저장
			session.setAttribute("id",id);
			session.setAttribute("nick","관리자");
			
			// main.jsp 파일로 리다이렉트, 새로고침시 재로그인이 불가능하도록 설정
			response.sendRedirect("main.jsp");
			
		} else {
			
			out.println("로그인 실패");
		    session.setAttribute("msg", "아이디 또는 비밀번호가 틀렸습니다." );
		    response.sendRedirect("login.jsp");
		    
			
		}
	%>
</body>
</html>