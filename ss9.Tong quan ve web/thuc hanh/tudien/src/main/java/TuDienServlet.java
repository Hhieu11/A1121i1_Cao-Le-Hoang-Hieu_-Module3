import javax.servlet.ReadListener;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TuDienServlet",urlPatterns = "/translate")
public class TuDienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");
        String result = dictionary.get(search);



        if(result!= null){
            request.setAttribute("result",result);
            request.setAttribute("search",search);

            RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);

        }
        else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("found.jsp");
            dispatcher.forward(request,response);

        }




    }
}
