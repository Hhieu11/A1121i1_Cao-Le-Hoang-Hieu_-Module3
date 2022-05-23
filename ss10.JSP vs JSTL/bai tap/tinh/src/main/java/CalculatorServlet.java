import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet" ,urlPatterns = "/calculate")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        float firstOperand = Integer.parseInt(request.getParameter("first-operand"));
        float secondOperand = Integer.parseInt(request.getParameter("second-operand"));
        char operator = request.getParameter("operator").charAt(0);
        Calculator calculator = new Calculator();
        try{
            float result = calculator.calculate(firstOperand,secondOperand,operator);
            request.setAttribute("firstOperand",firstOperand);
            request.setAttribute("secondOperand",secondOperand);
            request.setAttribute("operator",operator);
            request.setAttribute("result",result);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request,response);


        }
        catch (Exception ex){
        PrintWriter writer = response.getWriter();
        writer.println("Error: " + ex.getMessage());

        }



}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
