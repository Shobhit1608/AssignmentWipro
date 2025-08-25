import java.io.*;
import jakarta.servlet.http.*;

public class welcomeservlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
           
            HttpSession session = request.getSession(false);
            PrintWriter out = response.getWriter();

            
            String name = (String) session.getAttribute("name");
            String email = (String) session.getAttribute("email");
            String address = (String) session.getAttribute("address");
            String gender = (String) session.getAttribute("gender");
            String password = (String) session.getAttribute("password");

            out.println("<html><body>");
            out.println("<h1>Welcome, " + name + "</h1>");
            out.println("<p><b>Email:</b> " + email + "</p>");
            out.println("<p><b>Address:</b> " + address + "</p>");
            out.println("<p><b>Gender:</b> " + gender + "</p>");
            out.println("<p><b>Password:</b> " + password + "</p>");
            out.println("</body></html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
