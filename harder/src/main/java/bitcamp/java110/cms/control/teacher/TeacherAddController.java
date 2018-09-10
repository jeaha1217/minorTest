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
            t.setName(keyIn.nextLine());
            
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
            
            App.teachers.add(t);
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    {
        Teacher m = new Teacher();
        m.setName("a");
        App.teachers.add(m);
        
        m = new Teacher();
        m.setName("b");
        App.teachers.add(m);
        
        m = new Teacher();
        m.setName("c");
        App.teachers.add(m);
        
        m = new Teacher();
        m.setName("d");
        App.teachers.add(m);
        
        m = new Teacher();
        m.setName("e");
        App.teachers.add(m);
    }
}