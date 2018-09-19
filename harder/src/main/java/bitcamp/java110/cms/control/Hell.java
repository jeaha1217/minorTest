package bitcamp.java110.cms.control;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;

@Component
public class Hell{
    @RequestMapping("hell")
    public void hello(ServletRequest request, ServletResponse response)
            throws Exception {
        PrintWriter out = response.getWriter();
        out.println("\nWhat the Hell..");
    }
}
