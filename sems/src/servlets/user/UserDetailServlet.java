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

@WebServlet("/user/detail.bit")
@SuppressWarnings("serial")
public class UserDetailServlet extends HttpServlet {

	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과목상세정보</title></head><body>");
		try {
			out.println("<h1>과목 상세정보</h1>");
			
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			int no = Integer.parseInt(request.getParameter("no")); 
			
			UserVo user = dao.detail(no);
			
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("	<th>사용자번호</th>");
			out.println("	<td>" + user.getNo() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>이메일</th>");
			out.println("	<td>" + user.getEmail() + "</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>비밀번호</th>");
			out.println(" <td>" + user.getPassword()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>이름</th>");
			out.println(" <td>" + user.getName()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>전화번호</th>");
			out.println(" <td>" + user.getTel()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>팩스번호</th>");
			out.println(" <td>" + user.getFax()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>우편번호</th>");
			out.println(" <td>" + user.getPostNo()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>주소</th>");
			out.println(" <td>" + user.getAddress()+"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("	<th>사진경로</th>");
			out.println(" <td>" + user.getPhotoPath()+"</td>");
			out.println("</tr>");
						
			out.println("</table>");
			out.println("<a href='list.bit?pageNo=1&pageSize=10'>목록</a> ");
			out.println("<a href='delete.bit?no="
					+ user.getNo()
					+ "'>삭제</a> ");
			out.println("<a href='update.bit?no="
					+ user.getNo()
					+ "'>변경</a><br>");
			
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}  
	


}