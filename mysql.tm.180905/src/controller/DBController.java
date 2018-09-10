package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Buy;

@WebServlet("*.db")
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 요청 주소에서 공통된 부분을 제외한 부분을 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		switch (command) {
		case "selectone.db":
			Connection con4 = null;
			PreparedStatement pstmt4 = null;
			ResultSet rs4 = null;
			
			// 데이터가 1개일 때는 변수로 생성
			Buy buy1 = null;
			
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
		
				//데이터베이스 연결
				con4 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/iteabang?characterEncoding=UTF-8&serverTimezone=UTC", "root", "Qkdrn645746!!");
				pstmt4 = con4.prepareStatement(
					"select * from buytbl where num=?");
				String num =  request.getParameter("num");
				
				// 문자열을 정수로 변환해서 ?에 바인딩
				pstmt4.setInt(1, Integer.parseInt(num));
				
				//sql을 실행하고 결과 저장하기
				rs4 = pstmt4.executeQuery();
				
				// 리턴된 데이터를 읽어서 list에 저장
				if(rs4.next()) {
					buy1 = new Buy();
					buy1.setNum(rs4.getInt("num"));
					buy1.setUserid(rs4.getString("userid"));
					buy1.setProductname(rs4.getString("productname"));
					buy1.setGroupname(rs4.getString("groupname"));
					buy1.setPrice(rs4.getInt("price"));
					buy1.setAmount(rs4.getInt("amount"));
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs4 != null)rs4.close();
					if(con4 != null)con4.close();
					if(pstmt4 != null)pstmt4.close();
				}catch(Exception e) {}
			}
			System.out.println(buy1);
			break;
		
		case "selectlist.db":
			Connection con3 = null;
			PreparedStatement pstmt3 = null;
			ResultSet rs3 = null;
			
			// select 구문은 결과를 저장할 변수가 필요
			List<Buy> list = new ArrayList<Buy>();
			
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
		
				//데이터베이스 연결
				con3 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/iteabang?characterEncoding=UTF-8&serverTimezone=UTC", "root", "Qkdrn645746!!");
				pstmt3 = con3.prepareStatement(
					"select * from buytbl");
				
				//sql을 실행하고 결과 저장하기
				rs3 = pstmt3.executeQuery();
				
				// 리턴된 데이터를 읽어서 list에 저장
				while(rs3.next()) {
					Buy buy = new Buy();
					buy.setNum(rs3.getInt("num"));
					buy.setUserid(rs3.getString("userid"));
					buy.setProductname(rs3.getString("productname"));
					buy.setGroupname(rs3.getString("groupname"));
					buy.setPrice(rs3.getInt("price"));
					buy.setAmount(rs3.getInt("amount"));
				
					list.add(buy);
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(rs3 != null)rs3.close();
					if(con3 != null)con3.close();
					if(pstmt3 != null)pstmt3.close();
				}catch(Exception e) {}
			}
			for(Buy buy : list) {System.out.println(buy);}
			break;
			
		case "delete.db":
			Connection con2 = null;
			PreparedStatement pstmt2 = null;
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
				
				//데이터베이스 연결
				con2 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/iteabang?characterEncoding=UTF-8&serverTimezone=UTC", "root", "Qkdrn645746!!");
				pstmt2 = con2.prepareStatement(
					"delete from usertbl where userid=?");
				pstmt2.setString(1, "iteabang");
				
				//sql을 실행하고 결과 저장하기
				int result = pstmt2.executeUpdate();
				if(result > 0) {
					System.out.println("삭제성공");
				}
				else {
					System.out.println("삭제할 데이터가 없습니다.");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con2 != null)con2.close();
					if(pstmt2 != null)pstmt2.close();
				}catch(Exception e) {}
			}
			break;
			
		case "insert.db":
			Connection con1 = null;
			PreparedStatement pstmt = null;
			try {
				//드라이버 클래스 로드
				Class.forName(
					"com.mysql.jdbc.Driver");
				
				//데이터베이스 연결
				con1 = 
					DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/iteabang?characterEncoding=UTF-8&serverTimezone=UTC", "root", "Qkdrn645746!!");
				pstmt = con1.prepareStatement(
					"insert into usertbl(userid, name, birthyear, addr, mobile, mdate) values(?,?,?,?,?,?)");
				pstmt.setString(1, "iteabang");
				pstmt.setString(2, "안중근");
				pstmt.setInt(3, 1905);
				pstmt.setString(4, "서울");
				pstmt.setString(5, "01012345678");
				pstmt.setDate(6, new Date(5, 11, 3));
				
				//sql을 실행하고 결과 저장하기
				int result = pstmt.executeUpdate();
				if(result > 0) {
					System.out.println("삽입성공");
				}
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}finally {
				try {
					if(con1 != null)con1.close();
					if(pstmt != null)pstmt.close();
				}catch(Exception e) {}
			}
			break;
			
		case "mysql.db":
			// 드라이버 클래스 로드
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				// 데이터베이스 연결
				try {
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/iteabang?characterEncoding=UTF-8&serverTimezone=UTC", "root",
							"Qkdrn645746!!");
					System.out.println(con);
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			break;
		case "oracle.db":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "scott",
						"tiger");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
