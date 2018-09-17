package bitcamp.java110.cms.control.student;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class StudentAddController {
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/add")
    public void add(Request request, Response response) {
        while(true) {
            Student s = new Student();
            
            s.setName(request.getParameter("name"));
            s.setEmail(request.getParameter("email"));
            s.setPassword(request.getParameter("password"));
            s.setSchool(request.getParameter("school"));
            s.setWorking(Boolean.parseBoolean(request.getParameter("work")));
            s.setTel(request.getParameter("tel"));
            
            PrintWriter out = response.getWriter();
            try {
                if(studentDao.insert(s) == 1) {
                    out.println("저장했습니다.");
                }
            }   catch (Exception e) {
                out.println("이미 존재하는 이메일 입니다.");
                System.out.println(e.getMessage());
            }
        }
    }
}