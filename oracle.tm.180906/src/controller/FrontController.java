package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.TMember;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService;

	public FrontController() {
		super();
		userService = UserServiceImpl.sharedInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청 경로에서 프로젝트 경로를 제거
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);

		// 세션을 사용하는 경우가 많으므로 여기서 세션을 미리 생성
		HttpSession session = request.getSession();
		// command가 콘솔에 출력되지 않으면 url 처리 불가능, form에서 전송할 때 사용할 URL과 Servlet이 처리하는 URL이 같은지 확인
	
		RequestDispatcher dispatcher = null;
		switch (command) {
		case "user/login":
			// 서비스 메소드 호출
			TMember user = userService.login(request);
			// 로그인에 실패한 경우
			if (user == null) {
				// key 이름 설정하기
				session.setAttribute("user", user);
				session.setAttribute("msg", "email이나 비밀번호가 틀렸습니다.");
			}
			// 로그인 성공한 경우
			else {
				session.setAttribute("user", user);
			}
			// 로그인 성공 여부에 상관없이 메인 페이지로 리다이렉트 시키기
			// ../가 메인인 이유는 현재 요청이 user/login이므로 현재 위치는 user이므로 메인은 상위로 이동
			response.sendRedirect("../");
			break;

		case "user/logout":
			// 세션을 초기화
			session.invalidate();

			// 시작페이지로 리다이렉트
			response.sendRedirect("../");
			break;

		case "user/register":
			// 단순 페이지 이동 , 출력하는 페이지의 경로를 설정할 때는 URL을 기준으로 합니다.
			// 
			dispatcher = request.getRequestDispatcher("/member/register.jsp");
			dispatcher.forward(request, response);
			break;
			
		case "user/insert":
 			//이 문장이 안나오면 링크 확인
 			System.out.println("회원가입 처리");
 			boolean r = userService.registerMember(
 					request);
 			if(r == true) {
 				//회원가입에 성공했을 때 처리
 				session.setAttribute(
 					"msg", "회원 가입에 성공하셨습니다.");
 				response.sendRedirect("../");
 			}else{
 				//회원가입에 실패했을 때 처리
 				session.setAttribute(
 					"registermsg", 
 					"회원 가입에 실패하셨습니다.");
 				response.sendRedirect("register");
 			}
 			break;
 			
		case "user/emailcheck":
			boolean result = userService.emailCheck(request);
			
			// JSON으로 출력할 때는 리턴받은 데이터를 바로 저장하지 못하기 때문에 JSON 객체로 변환해서 저장
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			
			// 데이터를 저장
			request.setAttribute("result", obj);
			
			// 결과 페이지로 포워딩 - 리다이렉트로 가능
			dispatcher = request.getRequestDispatcher("/member/emailcheck.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
