package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentController {
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/add")
    public void add(ServletRequest request, ServletResponse response)
            throws Exception {
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
    
    @RequestMapping("student/delete")
    public void delete(ServletRequest request, ServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        PrintWriter out = response.getWriter();
        
        if(studentDao.delete(no) > 0) {
            out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 번호가 없습니다.");
    }
    
    @RequestMapping("student/detail")
    public void detail(ServletRequest request, ServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        Student student = studentDao.findByNo(no);
        PrintWriter out = response.getWriter();
        if(student == null) {
            out.println("해당하는 번호가 없습니다.");
            return;
        }
        
        out.printf("이름 : %s\n", student.getName());
        out.printf("이메일 : %s\n", student.getEmail());
        out.printf("암호 : %s\n", student.getPassword());
        out.printf("최종학력 : %s\n", student.getSchool());
        out.printf("전화 : %s\n", student.getTel());
        out.printf("재직여부 : %b\n", student.isWorking());
    }
    
    @RequestMapping("student/list")
    public void list(ServletRequest request, ServletResponse response)
            throws Exception {
        PrintWriter out = response.getWriter();
        List<Student> list = studentDao.findAll();

        for(Student s : list) {
            out.printf("%d : %s, %s, %s, %b, \n",
                    s.getNo(),
                    s.getName(),
                    s.getEmail(),
                    s.getSchool(),
                    s.isWorking()
                    );
        }
    }
}