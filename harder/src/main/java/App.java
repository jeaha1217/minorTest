import java.util.Scanner;

public class App {
    //  여러 속성값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용.
    static class Member{
        protected String name;
        protected String email;
        protected String password;
        
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
    
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

    static Student[] students = new Student[100];
    static Teacher[] teachers = new Teacher[100];
    
    
    static int studentIndex = 0;
    static int teacherIndex = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                seviceStudentMenu();
            }   else if(menu.equals("2")){
                serviceTeacherMenu();
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        
        keyIn.close();
        
    }

    private static void serviceTeacherMenu() {
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



    private static void seviceStudentMenu() {
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

    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1.학생 관리");
        System.out.println("2.강사 관리");
        System.out.println("3.매니져 관리");
        System.out.println("0.종료");
        
        while(true) {
            System.out.println("메뉴 번호>");
            
            String menu = keyIn.nextLine();
            
            switch(menu) {
            case "1" :
            case "2" :
            case "3" :
            case "0" :
                return menu;
            default : 
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }
        }
    }
    
    static void printStudents() {
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
    
    private static void printTeachers() {
        int count = 0;
        for(Teacher s : teachers) {
            if(count++ == studentIndex)
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
    
    static void inputStudents() {
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
