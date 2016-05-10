package uta.sis.tvpk;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


/*

http://localhost:8080/no-spring/hello
OR if deployed as ROOT then just

http://localhost:8080/hello

 */
@WebServlet(value="/hello", name="helloServlet")
public class HelloServlet extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("ssdfasdf");

        res.getWriter().println("Hello world!!");
    }
}
