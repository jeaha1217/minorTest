package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerDeleteController {
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
        
    @RequestMapping("manager/delete")
    public void delete(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        PrintWriter out = response.getWriter();
        
        if(managerDao.delete(no) > 0) {
            out.println("삭제되었습니다.");
            return;
        }
        out.println("해당하는 번호가 없습니다.");
    }
}