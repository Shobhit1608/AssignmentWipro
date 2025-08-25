import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class userformservlet extends HttpServlet {

    public void service(HttpServletRequest request, HttpServletResponse response) {
        try {
            
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String address = request.getParameter("address");
            String gender = request.getParameter("gender");
            String password = request.getParameter("password");

            
            HttpSession session = request.getSession();
            session.setAttribute("name", name);
            session.setAttribute("email", email);
            session.setAttribute("address", address);
            session.setAttribute("gender", gender);
            session.setAttribute("password", password);

            response.sendRedirect("welcome");

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
