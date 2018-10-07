package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        //  jsp 페이지에서 사용할 데이터 준비
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        Manager m = managerDao.findByNo(no);
        
        //  jsp 페이지에서 사용할 수 있도록 ServletRequest 보관소에 저장.
        request.setAttribute("manager", m);
        
        //  jsp 페이지를 인클루드 하기 전, content 타입 설정.
        response.setContentType("text/html;charset=UTF-8");
        
        //   jsp 페이지 인클루딩
        RequestDispatcher rd = request.getRequestDispatcher
                ("/manager/detail.jsp");
        rd.include(request, response);
    }
}

