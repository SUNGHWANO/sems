package servlets.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.CourseVo;
import dao.CourseDao;

@WebServlet("/course/list.bit")
@SuppressWarnings("serial")
public class CourseListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>과정목록</title></head><body>");
		try{
		out.println("<h1>과정목록</h1>");
		
		CourseDao dao = (CourseDao)this.getServletContext().getAttribute("courseDao");
		
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		
		List<CourseVo> list = dao.list(pageNo, pageSize);
		
		out.println("<a href='course.html'>새과정</a><br>");
		out.println("<table border='1'>");
		out.println("<tr><th>번호</th><th>과정</th></tr>");
			
		for (CourseVo course : list) {
			out.println("<tr>");
			out.println("	<td>" + course.getNo() + "</td>");
			out.println("	<td><a href='detail.bit?no="
					+ course.getNo()
					+ "'>" + course.getTitle() + "</a></td>");
			out.println("</tr>");
		}
			
		out.println("</table>");
		
		
		}catch(Throwable e){
			out.println("오류발생");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
