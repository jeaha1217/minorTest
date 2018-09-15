package bitcamp.java110.cms.control;

import java.io.PrintStream;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hell{
    @RequestMapping("hell")
    public void hello(PrintStream out) {
        out.println();out.flush();
        out.println("\nWhat the Hell..");out.flush();
        out.println();out.flush();
        out.flush();
    }
}
