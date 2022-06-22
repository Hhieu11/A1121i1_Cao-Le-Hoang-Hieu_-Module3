package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    private static String jdbcUrl = "jdbc:mysql://localhost:3306/furama_case";
    private static String username = "root";
    private static String password = "hieu1102";


    public static Connection getConnect(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(jdbcUrl,username ,password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return connection;
    }
}
