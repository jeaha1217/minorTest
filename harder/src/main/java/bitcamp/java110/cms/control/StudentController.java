package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.domain.Member;

public class StudentController {
    static Student[] students = new Student[100];
    static int studentIndex = 0;
    public static Scanner keyIn;
    
    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;
        
        public String getSchool() {
            return school;
        }
        public boolean isWorking() {
            return working;
        }
        public String getTel() {
            return tel;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }
    
    public static void seviceStudentMenu() {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printStudents();
            }   else if(command.equals("add")){
                inputStudents();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private static void printStudents() {
        int count = 0;
        for(Student s : students) {
            if(count++ == studentIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s \n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getSchool(),
                    s.isWorking(),
                    s.getTel()
                    );                
        }
    }
    
    private static void inputStudents() {
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
            
            students[studentIndex++] = m;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
}
