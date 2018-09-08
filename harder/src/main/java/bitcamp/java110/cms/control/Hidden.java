package bitcamp.java110.cms.control;

import java.util.Scanner;

public class Hidden implements Controller{
    public String name = "hidden";
    @Override
    public void service(Scanner keyIn) {
        System.out.println("Ah?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}
