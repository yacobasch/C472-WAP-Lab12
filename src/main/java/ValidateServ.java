import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class for Servlet: InboxServ
 */
public class ValidateServ extends HttpServlet implements Servlet {

    public ValidateServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN VALIDATESERV DOGET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sess = request.getSession();
        System.out.println("IN VALIDATESERV DOPOST");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        System.out.println("USERNAME: " + userName);
        System.out.println("PASSWORD: " + password);
        String passwordConfig = getServletConfig().getInitParameter("password");
        System.out.println(passwordConfig);

        if ("user1".equals(userName) && passwordConfig.equals(password)) {
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServ");
            rd.forward(request, response);
        } else {
            response.sendRedirect("FailureServ");
        }
    }
}