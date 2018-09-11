package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Autowired;
import bitcamp.java110.cms.annotaion.Component;
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
        System.out.print("삭제할 매니져의 이메일 : ");
        String email = keyIn.nextLine();
        
        if(managerDao.delete(email) > 0) {
            System.out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 메일 주소가 없습니다.");
        
    }
}