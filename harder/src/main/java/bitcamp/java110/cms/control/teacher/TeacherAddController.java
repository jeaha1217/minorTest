package bitcamp.java110.cms.control.teacher;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherAddController {
    TeacherDao teacherDao;

    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Request request, Response response) {
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
}