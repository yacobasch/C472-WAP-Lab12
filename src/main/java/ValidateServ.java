
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ValidateServ extends HttpServlet implements Servlet {

    public ValidateServ() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("IN VALIDATESERV DOGET");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Integer> Users = new HashMap<>();
        User user1 = new User("yac", "123");
        User user2 = new User("wes", "123");
        Users.put("yac", user1.hashCode());
        Users.put("wes", user2.hashCode());

        HttpSession sess = request.getSession();
        System.out.println("IN VALIDATESERV DOPOST");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if (Users.containsKey(userName) && Users.get(userName).equals((new User(userName,password)).hashCode())) {
            RequestDispatcher rd = request.getRequestDispatcher("SuccessServ");
            rd.forward(request, response);
        } else {
            response.sendRedirect("FailureServ");
        }
    }
}