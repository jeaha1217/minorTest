package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerDetailController {
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
        
    @RequestMapping("manager/detail")
    public void detail(Request request, Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        
        Manager manager = managerDao.findByNo(no);
        PrintWriter out = response.getWriter();
        
        if(manager == null) {
            out.println("해당하는 번호가 없습니다.");
            return;
        }
        
        out.printf("\n회원번호 : %d\n", manager.getNo());
        out.printf("이름 : %s\n", manager.getName());
        out.printf("이메일 : %s\n", manager.getEmail());
        out.printf("암호 : %s\n", manager.getPassword());
        out.printf("전화 : %s\n", manager.getTel());
        out.printf("직위 : %s\n", manager.getPosition());
    }
}

//  ?