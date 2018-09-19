package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherController {
    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(ServletRequest request, ServletResponse response)
            throws Exception {
        PrintWriter out = response.getWriter();
        while(true) {
            Teacher t = new Teacher();

            t.setName(request.getParameter("name"));
            t.setEmail(request.getParameter("email"));
            t.setPassword(request.getParameter("password"));
            t.setTel(request.getParameter("tel"));
            t.setSubject(request.getParameter("subject"));

            try {
                t.setPay(Integer.parseInt(request.getParameter("pay")));
            }   catch(Exception e) {
                out.println("\n!!급여항목 입력 오류!!\n");
                continue;
            }

            if(teacherDao.insert(t) == 1) {
                out.println("저장했습니다.");
            }   else {
                out.println("이미 존재하는 이메일 입니다.");
            }
        }
    }
    
    @RequestMapping("teacher/delete")
    public void delete(ServletRequest request, ServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        PrintWriter out = response.getWriter();
        
        if(teacherDao.delete(no) > 0) {
            out.println("삭제되었습니다.");
            return;
        }
        out.println("해당하는 번호가 없습니다.");
    }
    
    @RequestMapping("teacher/detail")
    public void detail(ServletRequest request, ServletResponse response)
            throws Exception {
        int no = Integer.parseInt(request.getParameter("no"));
        
        Teacher teacher = teacherDao.findByNo(no);
        PrintWriter out = response.getWriter();
        
        if(teacher == null) {
            out.println("해당하는 번호가 없습니다.");
            return;
        }
        
        out.printf("이름 : %s\n", teacher.getName());
        out.printf("이메일 : %s\n", teacher.getEmail());
        out.printf("암호 : %s\n", teacher.getPassword());
        out.printf("전화 : %s\n", teacher.getTel());
        out.printf("급여 : %d\n", teacher.getPay());
        out.printf("과목 : %s\n", teacher.getSubject());
    }
    
    @RequestMapping("teacher/list")
    public void list(ServletRequest request, ServletResponse response)
            throws Exception {
        List<Teacher> list = teacherDao.findAll();
        
        PrintWriter out = response.getWriter();
        for(Teacher t : list) {
            out.printf("%d : %s, %s, %d, [%s] \n",
                    t.getNo(),
                    t.getName(),
                    t.getEmail(),
                    t.getPay(),
                    t.getSubject()
                    );
        }
    }
}