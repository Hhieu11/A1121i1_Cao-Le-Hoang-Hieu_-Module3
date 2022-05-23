import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        if ("admin".equals(username) && "admin".equals(password)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("dung.jsp");
            dispatcher.forward(request, response);
            System.out.println("hehe");

        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("sai.jsp");
            dispatcher.forward(request, response);

        }


    }
}
