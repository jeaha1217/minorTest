package bitcamp.java110.cms.control;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Student;

public class StudentController implements Control{

    private List<Student> students;
    public Scanner keyIn;
    
    public StudentController(List<Student> students) {
        this.students = students;
        init();
    }
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printStudents();
            }   else if(command.equals("add")){
                inputStudents(keyIn);
            }   else if(command.equals("delete")) {
                deleteStudents(keyIn);
            }   else if(command.equals("detail")) {
                detailStudent(keyIn);
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private void printStudents() {
        for(int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.printf("%s : %s, %s, %s, %s, %b, %s \n",
                    i,
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel()
                    );                
        }
    }
    
    private void inputStudents(Scanner keyIn) {
        while(true) {
            Student m = new Student();
            
            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력 : ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직 여부 : ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());
            
            students.add(m);
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    private void deleteStudents(Scanner keyIn) {
        System.out.print("삭제할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        students.remove(no);
        
        System.out.println("삭제되었습니다.");
    }
    

    private void detailStudent(Scanner keyIn) {
        System.out.print("조회할 번호 : ");
        int no = Integer.parseInt(keyIn.nextLine());
        if(no < 0 || no >= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Student student = students.get(no);
        
        System.out.printf("이름 : %s\n", student.getName());
        System.out.printf("이메일 : %s\n", student.getEmail());
        System.out.printf("암호 : %s\n", student.getPassword());
        System.out.printf("최종학력 : %s\n", student.getSchool());
        System.out.printf("전화 : %s\n", student.getTel());
        System.out.printf("재직여부 : %b\n", student.isWorking());
        
    }
    
    private void init(){
        Student m = new Student();
        m.setName("a");
        students.add(m);
        
        m = new Student();
        m.setName("b");
        students.add(m);
        
        m = new Student();
        m.setName("c");
        students.add(m);
        
        m = new Student();
        m.setName("d");
        students.add(m);
        
        m = new Student();
        m.setName("e");
        students.add(m);
    }
}
