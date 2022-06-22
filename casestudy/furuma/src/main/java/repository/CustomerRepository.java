package repository;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    private BaseRepository baseRepository= new BaseRepository();
    public List<Customer> getCustomerList() {
        List<Customer>customerList=new ArrayList<>();

        try {
            PreparedStatement preparedStatement = this.baseRepository.getConnect().prepareStatement("SELECT * FROM khach_hang");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
//                customerList.add(new Customer(rs.getInt(1),
//                        rs.getString(3),
//                        rs.getString(4),
//                        rs.getString(6),
//                        rs.getString(5),
//                        rs.getString(7),
//                        rs.getString(8),
//                        rs.getString(2),
//                        rs.getString(9))
//                        );
                    int id=rs.getInt("id");
                    String name=rs.getString("name");
                    String dateOfBirth=rs.getString("dateOfBirth");
                    String idCard=rs.getString("idCard");
                    String sex=rs.getString("sex");
                    String sdt=rs.getString("sdt");
                    String email=rs.getString("email");
                    String customerType=rs.getString("customerType");
                    String address=rs.getString("address");
                    Customer customer= new Customer(id,name,dateOfBirth,idCard,sex,sdt,email,customerType,address);
                    customerList.add(customer);



            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return  customerList;



    }
    public Integer getIdMax() {
        Connection connection = BaseRepository.getConnect();

        int id = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Max(ma_khach_hang) FROM khach_hang");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }
}
