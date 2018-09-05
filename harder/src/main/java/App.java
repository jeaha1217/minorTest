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

    static Student[] students = new Student[100];
    
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                seviceStudentMenu();
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        
        keyIn.close();
        
    }

    private static void seviceStudentMenu() {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printStudents();
            }   else if(command.equals("add")){
                inputMembers();
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
            if(count++ == index)
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
    
    static void inputMembers() {
        while(true) {
            Student m = new Student();
            
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("eMail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            students[index++] = m;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    
}
