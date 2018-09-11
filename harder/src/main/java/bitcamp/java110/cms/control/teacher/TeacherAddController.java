package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while(true) {
            Teacher t = new Teacher();
            
            System.out.print("이름 : ");
            t.setEmail(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            t.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            t.setPassword(keyIn.nextLine());
            
            System.out.print("전화 : ");
            t.setTel(keyIn.nextLine());
            
            System.out.print("급여 : ");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의 과목 (예: 자바, C, C++) : ");
            t.setSubject(keyIn.nextLine());
            
            if(App.teacherDao.insert(t) > 0) {
                System.out.println("저장하였습니다.");
            }   else {
                System.out.println("같은 이메일의 강사가 존재 합니다.");
            }
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    {
        Teacher t = new Teacher();
        t.setEmail("a");
        App.teacherDao.insert(t);
        
        t = new Teacher();
        t.setEmail("b");
        App.teacherDao.insert(t);
        
        t = new Teacher();
        t.setEmail("c");
        App.teacherDao.insert(t);
        
        t = new Teacher();
        t.setEmail("d");
        App.teacherDao.insert(t);
        
        t = new Teacher();
        t.setEmail("e");
        App.teacherDao.insert(t);
    }
}