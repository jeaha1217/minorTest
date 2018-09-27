package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
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
        }
        
        TeacherDao teacherDao = (TeacherDao) this.getServletContext()
                .getAttribute("teacherDao");
        
        if(teacherDao.insert(t) == 1) {
            out.println("저장했습니다.");
        }   else {
            out.println("이미 존재하는 이메일 입니다.");
        }
    }
}