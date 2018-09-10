package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;

@Component("hidden")
public class Hidden{
    @RequestMapping
    public void hidden(Scanner keyIn) {
        System.out.println("Ah?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}
