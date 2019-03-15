import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServ extends HttpServlet implements Servlet {

    public LoginServ() {
        super();
        System.out.println("IN CONSTRUCTOR");
    }


    public void init() {
        System.out.println("IN INIT");
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN SERVICE");

        if ("GET".equalsIgnoreCase(request.getMethod())) {
            doGet(request, response);
        } else if ("POST".equalsIgnoreCase(request.getMethod())) {
            doPost(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        System.out.println("IN DOGET");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<form method=\"post\" action=\"ValidateServ\">");
        out.println("Username: <input name=\"userName\" maxlength=\"10\">");
        out.println("<br>");
        out.println("<br>");
        out.println("Password: <input type=\"password\" name=\"password\" maxlength=\"10\">");
        out.println("<br>");
        out.println("<br>");
        out.println("<input type=\"submit\" name=\"Login\" value=\"Login\">");
        out.println("<br>");
        out.println("<br>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN DOPOST");
    }

    public void destroy() {
        System.out.println(" IN DESTROY");
    }
}