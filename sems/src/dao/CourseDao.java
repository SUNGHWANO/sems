package dao;

import java.util.List;

import vo.CourseVo;
import vo.SubjectVo;

public interface CourseDao{
	void insert(CourseVo course) throws Throwable;
	List<CourseVo> list(int pageNo, int pageSize) throws Throwable;
	SubjectVo detail(int no) throws Throwable;
	void update(CourseVo course) throws Throwable;
	void delete(int no) throws Throwable;
}
