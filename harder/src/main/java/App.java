import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import bitcamp.java110.cms.control.ManagerController;
import bitcamp.java110.cms.control.StudentController;
import bitcamp.java110.cms.control.TeacherController;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class App {
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        StudentController sc = new StudentController(new LinkedList<Student>());
        TeacherController tc = new TeacherController(new LinkedList<Teacher>());
        ManagerController mc = new ManagerController(new ArrayList<Manager>());
        //  
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                sc.service(keyIn);
            }   else if(menu.equals("2")){
                tc.service(keyIn);
            }   else if(menu.equals("3")){
                mc.service(keyIn);
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        
        keyIn.close();
        
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

}
