package servlets.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@WebServlet("/user/update.bit")
@SuppressWarnings("serial")
public class UserUpdateServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자변경</title></head><body>");
		
		try {
			//1) DB에서 사용자 상세 정보를 가져온다.
			int no = Integer.parseInt(request.getParameter("no"));
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			UserVo vo = dao.detail(no);
			
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<meta charset='UTF-8'>");
			out.println("<title>사용자 변경폼</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>사용자 변경</h1>");
			out.println("<form action='update.bit' method='post'>");
			out.println("사용자번호: <input type='text' name='no' value='"
					+ vo.getNo()
					+ "' readonly><br>");
			out.println("이메일: <input type='text' name='email' value='"
					+ vo.getEmail()
					+ "'><br>");
			out.println("암호: <input type='text' name='password' value='"
					+ vo.getPassword()
					+ "'><br>");
			out.println("사용자명: <input type='text' name='username' value='"
					+ vo.getName()
					+ "'><br>");
			out.println("전화: <input type='text' name='tel' value='"
					+ vo.getTel()
					+ "'><br>");
			out.println("팩스: <input type='text' name='fax' value='"
					+ vo.getFax()
					+ "'><br>");
			out.println("우편번호: <input type='text' name='postno' value='"
					+ vo.getPostNo()
					+ "'><br>");
			out.println("주소: <input type='text' name='address' value='"
					+ vo.getAddress()
					+ "'><br>");
			out.println("사진경로: <input type='text' name='photopath' value='"
					+ vo.getPhotoPath()
					+ "'><br>");
			out.println("<input type='submit' value='변경'>");
			out.println("<input type='button' value='취소'");
			out.println(" onclick=\"location.href='detail.bit?no="
					+ vo.getNo()
					+ "'\">");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// CharacterEncodingFilter로 대체함.
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자변경</title></head><body>");
		
		try {
			out.println("<h1>사용자 변경 결과</h1>");
			
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			UserVo vo = new UserVo();
			vo.setNo(Integer.parseInt(request.getParameter("no")));
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setName(request.getParameter("username"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostNo(request.getParameter("postno"));
			vo.setAddress(request.getParameter("address"));
			vo.setPhotoPath(request.getParameter("photopath"));
			
			dao.update(vo);
			
			out.println("변경 성공!");
			
			response.sendRedirect("detail.bit?no=" + vo.getNo());
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}



