package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

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
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        Manager m = managerDao.findByNo(no);

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>매니져 관리</title>");
        
        //  css 파일 첨부
        out.println("<link rel='stylesheet' href='../css/common.css'>");
        
        out.println("<style>");
        out.println("table, th, td {");
        out.println("    border: 1px solid gray;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        
        //  페이지 머릿말 포함하기
        RequestDispatcher rd = request.getRequestDispatcher("/header");
        rd.include(request, response);
        
        out.println("<h1>매니져 상세 조회</h1>");

        if(m == null) {
            out.println("<p>해당하는 번호가 없습니다.</p>");
        }   else {
            out.println("<table><tbody>");
            
            out.printf("<tr><th>번호</th> <td>%d</td></tr>", m.getNo());
            out.printf("<tr><th>이름</th> <td>%s</td></tr>", m.getName());
            out.printf("<tr><th>이메일</th> <td>%s</td></tr>", m.getEmail());
            out.printf("<tr><th>직위</th> <td>%s</td></tr>", m.getPosition());
            out.println("</tbody></table>");
            
            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }
        out.println("<script>");
        out.println("function remove() {");
        out.printf(" location.href = 'delete?no=%d'\n",m.getNo());
        out.println("}");
        out.println("</script>");
        
        //  페이지 꼬릿말 포함하기.
        rd = request.getRequestDispatcher("/footer");
        rd.include(request, response);
        
        out.println("</body>");
        out.println("</html>");
    }
}

