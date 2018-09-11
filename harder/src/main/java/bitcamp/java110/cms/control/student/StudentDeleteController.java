package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;

@Component
public class StudentDeleteController {
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 학생의 이메일 : ");
        String email = keyIn.nextLine();
        
        if(App.studentDao.delete(email) > 0) {
            System.out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 메일 주소가 없습니다.");
        
    }
}