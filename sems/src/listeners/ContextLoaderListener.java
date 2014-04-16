package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.DBConnectionPool;
import dao.MysqlCourseDao;
import dao.MysqlSubjectDao;
import dao.MysqlUserDao;

public class ContextLoaderListener implements ServletContextListener {
	DBConnectionPool dbConnectionPool;
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("contextDestroyed....");
		dbConnectionPool.closeAll();

	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("contextInitialized....");
		ServletContext sc = event.getServletContext();
		dbConnectionPool = new DBConnectionPool();
		dbConnectionPool.setDriver(sc.getInitParameter("driver"));
		dbConnectionPool.setUrl(sc.getInitParameter("url"));
		dbConnectionPool.setUsername(sc.getInitParameter("username"));
		dbConnectionPool.setPassword(sc.getInitParameter("password"));
		
		MysqlSubjectDao subjectDao = new MysqlSubjectDao();
		subjectDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("subjectDao", subjectDao);
		
		MysqlUserDao userDao = new MysqlUserDao();
		userDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("userDao", userDao);
		
		MysqlCourseDao courseDao = new MysqlCourseDao();
		courseDao.setDBConnectionPool(dbConnectionPool);
		sc.setAttribute("courseDao", courseDao);
	}

}










