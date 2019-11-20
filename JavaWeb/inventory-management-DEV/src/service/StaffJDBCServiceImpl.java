package service;

import model.Staff;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffJDBCServiceImpl implements StaffService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String INSERT_STAFF = "INSERT INTO staff ( name , age, userName, address, phoneNumber,gender, createBy) VALUES (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_STAFFS = "SELECT idStaff, name,pass, age, address, phoneNumber,gender,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate FROM staff where isDelete = 0";
    private static final String SELECT_USER_BY_ID_STAFF = "SELECT idStaff, name,pass,age ,address, phoneNumber,gender,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate FROM staff where idStaff = ?";
    private static final String UPDATE_STAFF = "UPDATE staff SET name = ?, age = ?,address = ?, phoneNumber = ? ,gender = ?,modifyBy = ?,pass = ? WHERE idStaff = ?;";
    private static final String DELETE_STAFF = "UPDATE staff SET isDelete = 1, deleteBy = ? where idStaff = ?";

    private static final String SELECT_LOGIN_BY_ACC = "SELECT * FROM staff where pass = ? AND userName = ? limit 1";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        }catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
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
    public List<Staff> findAll() {
        List<Staff> staffs = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFFS)) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int idStaff = rs.getInt("idStaff");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    String PhoneNumber = rs.getString("phoneNumber");
                    String gender = rs.getString("gender");
                    String deleteBy = rs.getString("deleteBy");
                    String deleteDate = rs.getString("deleteDate");
                    String modifyBy = rs.getString("modifyBy");
                    String modifyDate = rs.getString("modifyDate");
                    String crecreateBy = rs.getString("createBy");
                    String creatDate = rs.getString("createDate");
                    String pass = rs.getString("pass");
                    staffs.add(new Staff(idStaff,name, pass, age, address, PhoneNumber,gender ,deleteBy,deleteDate,modifyBy, modifyDate,crecreateBy, creatDate));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffs;
    }

    @Override
    public void save(Staff staff) {
        System.out.println(INSERT_STAFF);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF)) {
            preparedStatement.setString(1, staff.getName());
            preparedStatement.setInt(2, staff.getAge());
            preparedStatement.setString(3, staff.getUserName());
            preparedStatement.setString(4, staff.getAddress());
            preparedStatement.setString(5, staff.getPhoneNumber());
            preparedStatement.setString(6, staff.getGender());
            preparedStatement.setString(7,staff.getCreateBy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Staff findById(int idStaff) {
        Staff staff = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID_STAFF);) {
            preparedStatement.setInt(1, idStaff);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String pass = rs.getString("pass");
                int age = rs.getInt("age");
                String address = rs.getString("address");
                String PhoneNumber = rs.getString("phoneNumber");
                String gender = rs.getString("gender");
                String deleteBy = rs.getString("deleteBy");
                String deleteDate = rs.getString("deleteDate");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate = rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");

                staff = (new Staff(idStaff, name, pass, age, address,PhoneNumber,gender, deleteBy, deleteDate, modifyBy , modifyDate, createBy,createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    @Override
    public void update(int idStaff, Staff staff) {

        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF);) {

            statement.setString(1, staff.getName());
            statement.setInt(2, staff.getAge());
            statement.setString(3, staff.getAddress());
            statement.setString(4, staff.getPhoneNumber());
            statement.setString(5, staff.getGender());

            statement.setString(6, staff.getModifyBy());
            statement.setString(7,staff.getPass());
            statement.setInt(8, staff.getIdStaff());
            statement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int idStaff,Staff staff) {
             boolean rowUpdated;
        try(Connection connection =getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STAFF);){
            statement.setString(1, staff.getDeleteBy());
            statement.setInt(2, staff.getIdStaff());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Staff CheckLogin(String pass, String userName) {
        Staff staff = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN_BY_ACC);) {
            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, userName);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String gender = rs.getString("gender");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                String userNamee = rs.getString("userName");
                String password = rs.getString("pass");
                Integer idStaff =rs.getInt("idStaff");
                staff = new Staff(idStaff, name, age, address, phoneNumber,gender,createBy,createDate,userNamee,password);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }
}
