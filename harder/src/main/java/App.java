import java.util.Scanner;

public class App {
    //  여러 속성값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용.
    static class Member{
        protected String name;
        protected String email;
        protected String password;
        
        //  인스턴스의 메모리를 다루는 operator = getter/setter = accessor = property = message
        
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
    //  Member를 담는 배열.
    static Member[] members = new Member[100];
    
    
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    static void inputMembers() {
        while(true) {
            Member m = new Member();
            
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("eMail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            members[index++] = m;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }   //  inputMembers()
    
    static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s \n", members[i].getName(), members[i].getEmail(), members[i].getPassword());                
        }
    }   //  printMembers
    
    public static void main(String[] args) {
        inputMembers();
        
        keyIn.close();
        
        printMembers();
    }   //  main
}
