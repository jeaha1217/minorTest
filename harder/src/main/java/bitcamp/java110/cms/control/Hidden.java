package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;

@Component("Hidden")
public class Hidden implements Controller{
    @Override
    public void service(Scanner keyIn) {
        System.out.println("Ah?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}
