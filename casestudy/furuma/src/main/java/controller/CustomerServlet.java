package controller;

import model.Customer;
import service.CustomerService;
import service.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/showCustomer")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService= new CustomerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewCustomer(request, response);
                break;
            case "delete":
//                deleteCustomer(request, response);
                break;
            case "update":
//                updateCustomer(request, response);
                break;
            case "search":
//                getCustomerListPage(request,response);
                break;
            default:
                getCustomerList(request,response);
                break;
        }



    }

    private void getCustomerList(HttpServletRequest request, HttpServletResponse response) {

        List<Customer> customerList = customerService.getCustomerList();
        request.setAttribute("listc", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id=customerService.getIdMax()+1;
        System.out.println(id);
        String name=request.getParameter("name");
        String sex =request.getParameter("sex");
        String idCard =request.getParameter("idCard");
        String email =request.getParameter("email");
        String dateOfBirth =request.getParameter("dateOfBirth");
        String sdt =request.getParameter("sdt");
        String typeCustomer =request.getParameter("typeCustomer");
        String address =request.getParameter("address");

        Customer customer= new Customer(id,name, dateOfBirth,idCard,sex,sdt,email,typeCustomer,address);
        customerService.addCustomerList(customer);

        request.setAttribute("mess","Thêm thành công!");
        getCustomerList(request,response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action ==null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("customerhdl.jsp");
                break;
            case "update":
//                goUpdate(request,response);
                break;
            case "search":
//                getCustomerListPage(request,response);
            default:
                getCustomerList(request,response);
                break;
        }

    }
}
