package servlets.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.UserVo;


//@WebServlet("/auth/login.bit")
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			// 쿠키 정보 꺼내기
			/*
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("loginEmail")) {
						request.setAttribute("loginEmail", cookie.getValue());
						break;
					}
				}
			}
			*/
			
			RequestDispatcher rd = 
					request.getRequestDispatcher("/auth/login.jsp");
			rd.forward(request, response);
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String saveEmail = request.getParameter("saveEmail");
			
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			UserVo userVo = null;
			try {
				// DB에서 사용자 정보 조회
				// 만약, 일치하는 사용자가 있다면
				// => 사용자 기본정보(이메일, 전화, 이름)를 가져와서 세션에 보관한다.
				userVo = dao.getUser(email, password);
				
				// getSession();
			  // - JSESSIONID(요청헤더의 쿠키정보)로 세션 객체를 찾아서 리턴한다.
				// - 만약 JSESSIONID에 해당하는 세션 객체를 찾지 못하면 새로 생성.
				// 					(세션이 타임아웃되어서 무효처리된 경우)
				//   JSESSIONID 쿠키 값이 요청 헤더에 없으면 새로 생성 
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", userVo);
				
			} catch (Throwable ex) {
			// 그 밖에, 일치하는 사용자가 없다면
				// => 로그인 입력폼 페이지로 보낸다.
				response.sendRedirect("login.bit");
				return;
			}
			
			
			
			if (saveEmail != null) {
				
				Cookie cookie = new Cookie("loginEmail", email);
				
				
				cookie.setDomain("s21.java48.com"); 
				cookie.setPath("/sems");				
				
			
				//cookie.setMaxAge(40);
				response.addCookie(cookie);
			}
			
			response.sendRedirect("/sems/index.html");
			
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
















