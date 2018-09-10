package bitcamp.java110.cms.control;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component("teacher")
public class TeacherController{

    private List<Teacher> teachers = new LinkedList<>();
    public TeacherController() {
        init();
    }
    @RequestMapping
    public void teacher(Scanner keyIn) {
        while(true) {
            System.out.println("강사관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printTeachers();
            }   else if(command.equals("add")){
                inputTeachers(keyIn);
            }   else if(command.equals("delete")) {
                deleteTeacher(keyIn);
            }   else if(command.equals("detail")) {
                detailTeacher(keyIn);
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    

    private void printTeachers() {
        for(int i = 0; i < teachers.size(); i++) {
            Teacher t = teachers.get(i);
            System.out.printf("%d : %s, %s, %s, %s, %d, %s \n",
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
    
    private void inputTeachers(Scanner keyIn) {
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
    
    private void deleteTeacher(Scanner keyIn) {
        System.out.print("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        teachers.remove(no);
        
        System.out.println("삭제하였습니다.");
    }

    private void detailTeacher(Scanner keyIn) {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher teacher = teachers.get(no);
        
        System.out.printf("이름 : %s\n", teacher.getName());
        System.out.printf("이메일 : %s\n", teacher.getEmail());
        System.out.printf("암호 : %s\n", teacher.getPassword());
        System.out.printf("전화 : %s\n", teacher.getTel());
        System.out.printf("급여 : %d\n", teacher.getPay());
        System.out.printf("과목 : %s\n", teacher.getSubject());
    }

    private void init(){
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
