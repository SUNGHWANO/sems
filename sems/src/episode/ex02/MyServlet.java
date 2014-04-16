package episode.ex02;

public class MyServlet implements Servlet{

	@Override
  public void service() {
		System.out.println("나는 서블릿이다");
  }

}
