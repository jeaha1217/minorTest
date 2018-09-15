package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    StudentDao studentDao;
    
    @Autowired
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student s = new Student();
            
            System.out.print("이름 : ");
            s.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            s.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            s.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력 : ");
            s.setSchool(keyIn.nextLine());
            
            System.out.print("재직 여부 : ");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화 : ");
            s.setTel(keyIn.nextLine());
            
            try {
                if(studentDao.insert(s) == 1) {
                    System.out.println("저장했습니다.");
                }
            }   catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
}