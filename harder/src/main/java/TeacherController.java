import java.util.Scanner;

public class TeacherController {
    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex = 0;
    static Scanner keyIn;
    
    static class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subject;
        
        public String getTel() {
            return tel;
        }
        public int getPay() {
            return pay;
        }
        public String getSubject() {
            return subject;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public void setSubject(String subject) {
            this.subject = subject;
        }
    }

    public static void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printTeachers();
            }   else if(command.equals("add")){
                inputTeachers();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private static void printTeachers() {
        int count = 0;
        for(Teacher s : teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s \n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getTel(),
                    s.getPay(),
                    s.getSubject()
                    );                
        }
    }
    
    static void inputTeachers() {
        while(true) {
            Teacher m = new Teacher();
            
            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("급여 : ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));
            
            System.out.print("강의 과목 (예: 자바, C, C++) : ");
            m.setSubject(keyIn.nextLine());
            
            teachers[teacherIndex++] = m;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }

}
