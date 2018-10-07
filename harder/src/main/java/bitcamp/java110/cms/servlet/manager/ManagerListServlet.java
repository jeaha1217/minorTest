package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/list")
public class ManagerListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        //  jsp가 사용할 데이터 준비
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        List<Manager> list = managerDao.findAll();
        
        response.setContentType("text/html;charset=UTF-8");
        
        // jsp가 사용할 수 있도록 ServletRequest 보관소에 저장
        request.setAttribute("list", list);
        
        //  jsp로 실행 위임
        RequestDispatcher rd = request.getRequestDispatcher
                ("/manager/list.jsp");
        rd.include(request, response);
    }
}

/*
Servlet은 이제 UI를 생성하는 코드가 없음.
UI생성은 JSP에서 담당.

Servlet
    - 클라이언트 요청을 받고, 요청 파라메터 값을 사용하기 적합하게 가공하는 역할.
    - DAO를 호출하여 준비함.
    - JSP에게 실행을 위임.
    - "Controller" component 라고 부름.
DAO
    - DBMS와 연동, 데이터를 처리함.
    - "Model" component 라고 부름.
JSP
    - 틀라이언트가 출력할 화면 생성.
    - "view" component 라고 부름.

클라이언트 요청이 들어왔을 때
이렇게 역할을 쪼개어 처리하는 방식을
MVC architecture(Model) 이라고 부름.

MVC 모델 1
    요청 ---> JSP ---> DAO ---> DBMS
        <---     <---     <---
        
 MVC 모델 2
    요청 ---> Servlet ---> DAO ---> DBMS
                ^ |
                | |
                | v
             JSP 페이지
*/