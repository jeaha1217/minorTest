package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;

@WebServlet("/manager/delete")
public class ManagerDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
                    throws ServletException, IOException {
        int no = Integer.parseInt(request.getParameter("no"));

        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");

        try {
            managerDao.delete(no);
            //  삭제가 이상없이 완료 된다면 목록 페이지로 되돌아간다.
            response.sendRedirect("list");
        }   catch (Exception e) {
            e.printStackTrace();
            //  삭제 결과를 출력하고 
            //  add와 과정은 같다.
            request.setAttribute("error", e);
            request.setAttribute("message", "매니져 삭제 오류!");
            response.setHeader("refresh", "3;url=list");
            
            //  한줄로 줄이기.
            request.getRequestDispatcher("/error").forward(request, response);
        }
    }
}