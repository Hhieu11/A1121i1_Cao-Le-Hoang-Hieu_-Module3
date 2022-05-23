import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DiscountServlet",urlPatterns = "/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double gia=Double.parseDouble(request.getParameter("gia"));
        double tyle=Double.parseDouble(request.getParameter("tyle"));
        double discountamount = gia*tyle * 0.01d;
        double total =gia-discountamount;

        request.setAttribute("gia",gia);
        request.setAttribute("tyle",tyle);
        request.setAttribute("discountamount",discountamount);
        request.setAttribute("total",total);
        RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
