package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;

@Component
public class ManagerDeleteController {
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
        
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(managerDao.delete(no) > 0) {
            System.out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 번호가 없습니다.");
    }
}