package episode.ex02;

public class CharSetFilter implements Filter {
	Filter nextFilter;

	public CharSetFilter(Filter nextFilter) {
		this.nextFilter = nextFilter;
	}

	@Override
	public void doFilter() {
		System.out.println("클라이언트 문자 집합 설정하기");
		
		nextFilter.doFilter();
	}

}
