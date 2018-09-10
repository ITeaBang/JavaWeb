package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Register() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 파라미터를 읽어서 출력
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String army = request.getParameter("army");
		
		System.out.println("email : " + email);
		System.out.println("password : " + pw);
		System.out.println("name : " + name);
		System.out.println("email : " + address);
		System.out.println("gender : " + gender);
		System.out.println("army : " + army);
		
		// 결과 페이지에 전송할 데이터를 저장
		request.setAttribute("msg","회원 가입에 성공하셨습니다.");
		
		// 결과 페이지로 포워딩
		/* RequestDispatcher dispatcher = request.getRequestDispatcher("output.jsp");
				dispatcher.forward(request, response); */
		
		request.getSession().setAttribute("msg", "회원 가입에 성공하셨습니다.");
		response.sendRedirect("output.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
