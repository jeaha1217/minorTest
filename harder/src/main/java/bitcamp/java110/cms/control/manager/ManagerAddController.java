package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Autowired;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while(true) {
            Manager m = new Manager();
            
            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("직위 : ");
            m.setPosition(keyIn.nextLine());
            
            int rtval = 0;
            if((rtval = managerDao.insert(m)) > 0) {
                System.out.println("저장하였습니다.");
            }   else if(rtval == -1) {
                System.out.println("필수 입력 항목이 비었습니다.");
            }   else if(rtval == -2) {
                System.out.println("같은 이메일의 매니져가 존재 합니다.");
            }   else {
                System.out.println("예기치 않은 오류가 발생했습니다.");
            }
            
            System.out.println("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
}