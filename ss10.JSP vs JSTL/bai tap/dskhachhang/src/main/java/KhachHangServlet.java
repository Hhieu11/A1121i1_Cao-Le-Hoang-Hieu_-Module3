import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet",urlPatterns = "/khachhang")
public class KhachHangServlet extends HttpServlet {
    public static List<khachhang> khachhangList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        khachhangList.add(new khachhang("Hoang Hieu",  "12/12/2022",  "Quang Ngai","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNKoNPVHeLs0dXrT1gJhuPheo4m5VNMl20nw&usqp=CAU"));
        khachhangList.add(new khachhang("Hoang Hieu1",  "12/12/2022",  "Quang Ngai","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbgYIk_g-7tS8nVpnG1Y9DVkuTotcbAFQJDQ&usqp=CAU"));

        khachhangList.add(new khachhang("Hoang Hieu2",  "12/12/2022",  "Quang Ngai","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTFylvvqG7muya8nkZG1P0aV24kMmX7pufl5g&usqp=CAU"));

        khachhangList.add(new khachhang("Hoang Hieu3",  "12/12/2022",  "Quang Ngai","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgu7Vzew59fN0pL-knLtoQnS3IXL4tSlroUQ&usqp=CAU"));


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("khachhangList",khachhangList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request,response);


    }
}
