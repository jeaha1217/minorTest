package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;

@Component
public class ManagerDeleteController {
    
    @RequestMapping("manager/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 매니져의 이메일 : ");
        String email = keyIn.nextLine();
        
        if(App.managerDao.delete(email) > 0) {
            System.out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 메일 주소가 없습니다.");
        
    }
}