package servlets.user90;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.UserVo;
import dao.UserDao;

@WebServlet("/subject/insert.bit")
@SuppressWarnings("serial")
public class UserInsertServlet extends HttpServlet {
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	  doGet(request, response);
	}
	
	@Override
	protected void doGet(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		// POST 요청의 값에 대해 적용. GET 요청의 값은?
		// - 서블릿 컨테이너의 안내에 따라 설정한다.
		// - getParameter()를 호출하기 전에 실행해야 한다.
		//   단, 한번이라도 getParameter()를 호출했다면 적용안됨. 
		
		//CharacterEncodingFilter로 대체함
		//request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>사용자등록</title></head><body>");
		
		try {
			out.println("<h1>사용자 등록 결과</h1>");
			
			UserDao dao = (UserDao)this.getServletContext()
					.getAttribute("userDao");
			
			UserVo vo = new UserVo();
			vo.setEmail(request.getParameter("email"));
			vo.setPassword(request.getParameter("password"));
			vo.setName(request.getParameter("name"));
			vo.setTel(request.getParameter("tel"));
			vo.setFax(request.getParameter("fax"));
			vo.setPostNo(request.getParameter("postNo"));
			vo.setAddress(request.getParameter("address"));
			vo.setPhotoPath(request.getParameter("photoPath"));
			
			dao.insert(vo);
			
			out.println("등록 성공!");
			
			response.setHeader("Refresh", "1;url=list.bit?pageNo=1&pageSize=10");
			
		} catch (Throwable e) {
			out.println("오류 발생 했음!");
			e.printStackTrace();
		}
		out.println("</body></html>");
	}
}
















