package service;

import model.Product;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductJDBCServiceImpl implements ProductServiceImpl{
    private String jdbcURL = "jdbc:mysql://localhost:????/mvc_product";
    private String jdbcUsername = "root";
    private String jdbcPassword = "manmeo96";

    private static final String INSERT_USER_SQL = "INSERT INTO Product " + "(id,name,description,amount,price) VALUES "
            + "(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select id,name,description,amount,price form Product where id=? ;";
    private static final String SELECT_ALL_USER = "select * from Product";
    private static final String DELETE_USER_SQL = "delete from Product where id = ? ;";
    private static final String UPDATE_USER_SQL = "update Product set name =?, description=?, amount=?, price=? where id =?;";

    protected Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
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
    public List<Product> findAll() throws SQLException {
        List<Product> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
             System.out.println(preparedStatement);
             ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name =rs.getString("name");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                users.add(new Product(id,name,description,amount,price));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }
    @Override
    public void save(Product product){
        System.out.println("INSERT_USERS_SQL");
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setInt(4,product.getAmount());
            preparedStatement.setFloat(5,product.getPrice());
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public Product findById(int id){
        Product product = null;
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID); ) {
            preparedStatement.setInt(1,id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                float price = rs.getFloat("price");
                product = new Product(id,name,description,amount,price);

            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }
    @Override
    public void update(int id, Product product){
        boolean rowUpdate;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
        statement.setInt(1,product.getId());
        statement.setString(2,product.getName());
        statement.setString(3,product.getDescription());
        statement.setInt(4,product.getAmount());
        statement.setFloat(5,product.getPrice());

        rowUpdate = statement.executeUpdate()>0;
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
    public void remove(int id){
        try (Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
