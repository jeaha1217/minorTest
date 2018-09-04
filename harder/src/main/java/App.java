import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //  filed 요소 배열
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords = new String[100];
        
        int index = 0;
        
        Scanner keyIn = new Scanner(System.in);
        
        while(true) {
            System.out.print("Name : ");
            names[index] = keyIn.nextLine();
        
            System.out.print("eMail : ");
            emails[index] = keyIn.nextLine();
        
            System.out.print("Password : ");
            passwords[index] = keyIn.nextLine();
        
        
            System.out.print("Continue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
            
            for(int i = 0; i < index; i++) {
                System.out.printf("%s, %s, %s", names[i], emails[i], passwords[i]);                
            }
            
            keyIn.close();
        }
    }
}
