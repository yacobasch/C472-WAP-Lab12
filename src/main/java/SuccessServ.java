import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SuccessServ extends HttpServlet implements Servlet {
    public SuccessServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN SUCESSSERV DOGET");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        System.out.println("IN SUCESSSERV DOPOST");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("COOKIE:" + request.getHeader("cookie"));
        out.println("<br>");
        out.println("Congratulations! You have entered the correct username and password");
        out.println("<br>");
        out.println("<a href=\'LogoutServ\'>You Can Logout here</a>");
        out.println("</body>");
        out.println("</html>");

    }
}