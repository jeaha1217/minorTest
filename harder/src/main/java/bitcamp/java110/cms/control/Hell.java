package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;

@Component
public class Hell{
    @RequestMapping("hell")
    public void hello(Scanner keyIn) {
        System.out.println("What the Hell..");
    }
}
