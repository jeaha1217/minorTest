package bitcamp.java110.cms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import bitcamp.java110.cms.dao.impl.ManagerMysqlDao;
import bitcamp.java110.cms.dao.impl.StudentMysqlDao;
import bitcamp.java110.cms.dao.impl.TeacherMysqlDao;
import bitcamp.java110.cms.util.DataSource;

public class ContextLoaderListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContextLoaderListener.contextInitialized() 실행!");
        
        ServletContext sc = sce.getServletContext();
        
        //  DAO가 사용할 DB 커넥션 객체 준비.
        //  => DataSource 객체를 만들 때 컨택스트 파라미터 값을 꺼내서 사용한다.
        try {
            DataSource dataSource = new DataSource(
                    sc.getInitParameter("jdbc.driver"),
                    sc.getInitParameter("jdbc.url"),
                    sc.getInitParameter("jdbc.username"),
                    sc.getInitParameter("jdbc.password"));
            
            //  DAO 객체 생성 및 DB ConnectionPool 주입하기.
            StudentMysqlDao studentDao = new StudentMysqlDao();
            studentDao.setDataSource(dataSource);
            TeacherMysqlDao teacherDao = new TeacherMysqlDao();
            teacherDao.setDataSource(dataSource);
            ManagerMysqlDao managerDao = new ManagerMysqlDao();
            managerDao.setDataSource(dataSource);
            
            //  서블릿에서 DAO를 이용할 수 있도록 ServletContext 보관소에 저장하기.
            sc.setAttribute("studentDao", studentDao);
            sc.setAttribute("teacherDao", teacherDao);
            sc.setAttribute("managerDao", managerDao);
            
        }   catch (Exception e){
            e.printStackTrace();
        }
    }
}
