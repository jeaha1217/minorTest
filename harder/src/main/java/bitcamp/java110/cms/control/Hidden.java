package bitcamp.java110.cms.control;

import java.io.PrintStream;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hidden{
    @RequestMapping("hidden")
    public void hidden(PrintStream out) {
        out.println();out.flush();
        out.println("\nAh?");out.flush();
        out.println("Fuck You");out.flush();
        out.println("Fuck You to Meet You");out.flush();
        out.println();
        out.flush();
    }
    
}
