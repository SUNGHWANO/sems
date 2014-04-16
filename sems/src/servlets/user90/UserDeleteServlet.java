package servlets.user90;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/user/delete.bit")
@SuppressWarnings("serial")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
		
		// 1) 응답 헤더에 Refresh 명령어 심기 
		//response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용삭제</title>");
		
		// 2) 응답 내용에 Refresh 명령어 심기
		//out.println("<meta http-equiv='Refresh'"
		//		+ " content='1;url=list.bit?pageNo=1&pageSize=10'>");
		out.println("</head><body>");
		
		try {
			out.println("<h1>사용자 삭제 결과</h1>");
			
			 UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			int no = Integer.parseInt(request.getParameter("no"));
			
			dao.delete(no);
			
			out.println("삭제 성공!");
			
			// 3) Redirect 처리
			// - 콘텐츠를 출력하지 않기 때문에 => 이전에 출력한 내용은 취소된다.
			response.sendRedirect("list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}





