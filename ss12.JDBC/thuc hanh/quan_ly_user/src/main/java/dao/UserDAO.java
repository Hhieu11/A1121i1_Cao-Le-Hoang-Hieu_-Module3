package dao;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserDAO  implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "hieu1102";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email, country) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String SEARCH_COUNTRY_SQL = "SELECT *\n" +
            "FROM users\n" +
            "WHERE country LIKE \"?\";";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";

    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";

    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"

            + "("

            + " ID serial,"

            + " NAME varchar(100) NOT NULL,"

            + " SALARY numeric(15, 2) NOT NULL,"

            + " CREATED_DATE timestamp,"

            + " PRIMARY KEY (ID)"

            + ")";

    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";




    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
        

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }


    @Override
    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;


    }

    @Override
    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;

    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
       boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {

        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
//        Connection connection=null;


    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> users = new ArrayList<>();
        String query="SELECT * " +
                "FROM users " +
                "WHERE country LIKE ? ;";

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,"%"+country+"%");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                users.add(new User( rs.getString("name"),
                rs.getString("email"),
                        rs.getString("country")));


            }

        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return users;
    }

    @Override
    public User getUserById(int id) {
        User user= null;
        String query="{CALL get_user_by_id(?)}";
        try (
                Connection connection= getConnection();
                CallableStatement callableStatement= connection.prepareCall(query);
                ) {
            callableStatement.setInt(1,id);
            ResultSet rs=callableStatement.executeQuery();

            while (rs.next()){

                String name = rs.getString("name");

                String email = rs.getString("email");

                String country = rs.getString("country");

                user = new User(id, name, email, country);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return user;
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        String query = "{CALL insert_user(?,?,?)}";
        try (Connection connection = getConnection();

             CallableStatement callableStatement = connection.prepareCall(query);) {

            callableStatement.setString(1, user.getName());

            callableStatement.setString(2, user.getEmail());

            callableStatement.setString(3, user.getCountry());

            System.out.println(callableStatement);

            callableStatement.executeUpdate();

        }      catch (SQLException e) {

        printSQLException(e);

    }


    }

    @Override
    public void addUserTransaction(User user, int[] permisions) {
        Connection conn=null;
        // để chèn người dùng mới

        PreparedStatement pstmt=null;

        // để gán hoán vị cho người dùng
        PreparedStatement pstmtAssignment = null;

        // để lấy id người dùng
        ResultSet rs=null;
        try {
            conn=getConnection();
            // đặt cam kết tự động thành false
            conn.setAutoCommit(false);

            // Insert user

            pstmt=conn.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getName());

            pstmt.setString(2, user.getEmail());

            pstmt.setString(3, user.getCountry());

            int rowAffected=pstmt.executeUpdate();
            // lấy id người dùng
            rs=pstmt.getGeneratedKeys();
            int userId=0;
            if(rs.next()){
                userId=rs.getInt(1);

            }
            // trong trường hợp thao tác chèn thành công, hãy gán hoán vị cho người dùng
            if(rowAffected==1){
                String sqlPivot="INSERT INTO user_permision(user_id,permision_id) "

                        + "VALUES(?,?)";
                pstmtAssignment=conn.prepareStatement(sqlPivot);
                for (int permisionId : permisions) {

                    pstmtAssignment.setInt(1, userId);

                    pstmtAssignment.setInt(2, permisionId);

                    pstmtAssignment.executeUpdate();

                }
                conn.commit();

            }
            else {

                conn.rollback();

            }

        } catch (SQLException ex) {
            // roll back the transaction

            try {

                if (conn != null)

                    conn.rollback();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

            System.out.println(ex.getMessage());

        }
        finally {

            try {

                if (rs != null) rs.close();

                if (pstmt != null) pstmt.close();

                if (pstmtAssignment != null) pstmtAssignment.close();

                if (conn != null) conn.close();

            } catch (SQLException e) {

                System.out.println(e.getMessage());

            }

        }


    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection conn = getConnection();

             Statement statement = conn.createStatement();

             PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

             PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {



            statement.execute(SQL_TABLE_DROP);

            statement.execute(SQL_TABLE_CREATE);



            // Run list of insert commands

            psInsert.setString(1, "Quynh");

            psInsert.setBigDecimal(2, new BigDecimal(10));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            psInsert.setString(1, "Ngan");

            psInsert.setBigDecimal(2, new BigDecimal(20));

            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

            psInsert.execute();



            // Run list of update commands



            // below line caused error, test transaction

            // org.postgresql.util.PSQLException: No value specified for parameter 1.

            psUpdate.setBigDecimal(2, new BigDecimal(999.99));



            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            psUpdate.setString(2, "Quynh");

            psUpdate.execute();



        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void insertUpdateUseTransaction() { try (Connection conn = getConnection();

                                                    Statement statement = conn.createStatement();

                                                    PreparedStatement psInsert = conn.prepareStatement(SQL_INSERT);

                                                    PreparedStatement psUpdate = conn.prepareStatement(SQL_UPDATE)) {

        statement.execute(SQL_TABLE_DROP);

        statement.execute(SQL_TABLE_CREATE);

        // start transaction block

        conn.setAutoCommit(false); // default true

        // Run list of insert commands

        psInsert.setString(1, "Quynh");

        psInsert.setBigDecimal(2, new BigDecimal(10));

        psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

        psInsert.execute();



        psInsert.setString(1, "Ngan");

        psInsert.setBigDecimal(2, new BigDecimal(20));

        psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));

        psInsert.execute();



        // Run list of update commands



        // below line caused error, test transaction

        // org.postgresql.util.PSQLException: No value specified for parameter 1.

        psUpdate.setBigDecimal(2, new BigDecimal(999.99));



        //psUpdate.setBigDecimal(1, new BigDecimal(999.99));

        psUpdate.setString(2, "Quynh");

        psUpdate.execute();



        // end transaction block, commit changes

        conn.commit();

        // good practice to set it back to default true

        conn.setAutoCommit(true);



    } catch (Exception e) {

        System.out.println(e.getMessage());

        e.printStackTrace();

    }


    }
}
