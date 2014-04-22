package servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


@WebServlet("/file/upload.bit")
@SuppressWarnings("serial")
public class FileUploadServlet extends HttpServlet {
	@Override
	protected void doPost(
			HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileFactory);
		
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			
			for (FileItem item : items) {
				if (item.isFormField()) { 
				
					request.setAttribute(item.getFieldName(), item.getString("UTF-8"));
					
				} else { 
					
					request.setAttribute(item.getFieldName(),	item.getName());
					
					// http://localhost:9898/okok파일 데이터 저장 
					// {톰캣 서버의 배치폴더}/웹애플리케이션/upload
					ServletContext sc = request.getServletContext();
					String fullPath = sc.getRealPath("/upload");
					File savedFile = new File(fullPath + "/" + item.getName());
					
					// savedFile 정보에 따라 해당 경로에 파일 저장
					item.write(savedFile); 
				}
			}
			
			RequestDispatcher rd = request.getRequestDispatcher(
					"/file/uploadResult.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}





















