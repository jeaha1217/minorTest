import java.util.Scanner;

public class App {
    //  field 요소 배열
    static String[] names = new String[100];
    static String[] emails = new String[100];
    static String[] passwords = new String[100];
    
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    static void inputMembers() {
        while(true) {
            System.out.print("Name : ");
            names[index] = keyIn.nextLine();
            
            System.out.print("eMail : ");
            emails[index] = keyIn.nextLine();
            
            System.out.print("Password : ");
            passwords[index] = keyIn.nextLine();
            
            index++;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }   //  inputMembers()
    
    static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s \n", names[i], emails[i], passwords[i]);                
        }
    }   //  printMembers
    
    public static void main(String[] args) {
        inputMembers();
        
        keyIn.close();
        
        printMembers();
    }   //  main
}
