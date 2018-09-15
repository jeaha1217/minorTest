package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Autowired;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(studentDao.delete(no) > 0) {
            System.out.println("삭제되었습니다.");
            return;
        }
        System.out.println("해당하는 번호가 없습니다.");
    }
}