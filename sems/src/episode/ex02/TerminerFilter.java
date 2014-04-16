package episode.ex02;

public class TerminerFilter implements Filter{
	Servlet worker;
	
	
	public TerminerFilter(Servlet worker){
		this.worker = worker;
	}
	
	@Override
  public void doFilter() {
		worker.service();
  }

}
