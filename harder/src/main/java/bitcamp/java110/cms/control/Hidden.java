package bitcamp.java110.cms.control;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotaion.RequestMapping;

@Component
public class Hidden{
    @RequestMapping("hidden")
    public void hidden(Scanner keyIn) {
        System.out.println("\nAh?");
        System.out.println("Fuck You");
        System.out.println("Fuck You to Meet You");
    }
    
}
