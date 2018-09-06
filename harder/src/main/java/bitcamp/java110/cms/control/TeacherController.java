package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.util.ArrayList;

public class TeacherController {
    private ArrayList teachers = new ArrayList();
    public Scanner keyIn;
    
    public TeacherController(Scanner keyIn) {
        this.keyIn = keyIn;
    }

    public void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printTeachers();
            }   else if(command.equals("add")){
                inputTeachers();
            }   else if(command.equals("delete")) {
                deleteTeacher();
            }   else if(command.equals("detail")) {
                detailTeacher();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    

    private void printTeachers() {
        for(int i = 0; i < teachers.size(); i++) {
            Teacher t = new Teacher();
            System.out.printf("%s, %s, %s, %s, %d, %s \n",
                    i,
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubject()
                    );                
        }
    }
    
    private void inputTeachers() {
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
            
            teachers.add(t);
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    private void deleteTeacher() {
        System.out.print("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        teachers.remove(no);
        
        System.out.println("삭제하였습니다.");
    }

    private void detailTeacher() {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher teacher = (Teacher)teachers.get(no);
        
        System.out.printf("이름 : %s\n", teacher.getName());
        System.out.printf("이메일 : %s\n", teacher.getEmail());
        System.out.printf("암호 : %s\n", teacher.getPassword());
        System.out.printf("전화 : %s\n", teacher.getTel());
        System.out.printf("월급 : %s\n", teacher.getPay());
        System.out.printf("과목 : %s\n", teacher.getSubject());
    }

    {
        Teacher m = new Teacher();
        m.setName("a");
        teachers.add(m);
        
        m = new Teacher();
        m.setName("b");
        teachers.add(m);
        
        m = new Teacher();
        m.setName("c");
        teachers.add(m);
        
        m = new Teacher();
        m.setName("d");
        teachers.add(m);
        
        m = new Teacher();
        m.setName("e");
        teachers.add(m);
    }
}
