package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerDetailController {
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
        
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        Manager manager = managerDao.findByNo(no);
        if(manager == null) {
            System.out.println("해당하는 번호가 없습니다.");
            return;
        }
        System.out.printf("\n회원번호 : %d\n", manager.getNo());
        System.out.printf("이름 : %s\n", manager.getName());
        System.out.printf("이메일 : %s\n", manager.getEmail());
        System.out.printf("암호 : %s\n", manager.getPassword());
        System.out.printf("전화 : %s\n", manager.getTel());
        System.out.printf("직위 : %s\n", manager.getPosition());
    }
}