package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
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
            
            try {
                if(managerDao.insert(m) == 1) {
                    System.out.println("저장했습니다.");
                }
            }   catch (Exception e) {
                System.out.println(e.getMessage());
            }
/*            
            두가지 방법 사용 가능. Dao.insert() 단에서 잘 처리했다면 위에 방법으로 하면 됨.
            어쨌거나 예외 처리는 확실하게 해야함.
            try {
                managerDao.insert(m);
                System.out.println("저장했습니다.");
            }   catch (MandatoryValueDaoExcecption ex) {
                System.out.println(ex);
                System.out.println("필수 값 누락 오류!");
            }   catch (DuplicationDaoException ex) {
                System.out.println(ex);
                System.out.println("이메일 중복 오류!");
            }
*/            
            System.out.println("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
}