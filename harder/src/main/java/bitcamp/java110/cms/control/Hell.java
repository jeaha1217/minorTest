package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;

@Component("4")
public class Hell implements Controller{
    public void service(Scanner keyIn) {
        System.out.println("Hell..");
    }
}
