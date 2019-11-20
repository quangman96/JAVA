package service;

import model.Stock;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StockJDBCServiceImpl implements StockService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_STOCKS = "select  * from stock where isDelete = 0";
    private static final String INSERT_STOCK_SQL = "INSERT INTO stock (name, address, phoneNumber, createBy) " +
            "VALUES (?,?,?,?)";
    private static final String UPDATE_STOCK_SQL =
            "UPDATE stock SET name = ?, address = ?, phoneNumber = ?, modifyBy = ? WHERE (idStock = ?);";
    private static final String SELECT_STOCK_BY_ID = "select * from stock WHERE (idStock = ?);";
    private static final String DELETE_STOCK_SQL = "UPDATE stock SET isDelete = 1, deleteBy = ? WHERE (idStock = ?);";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
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
    public List<Stock> findAll() {
        List<Stock> stocks = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCKS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStock = rs.getInt("idStock");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String deleteBy = rs.getString("deleteBy");
                String deleteDate = rs.getString("deleteDate");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate = rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                stocks.add(new Stock(idStock, name, address, phoneNumber, deleteBy, deleteDate, modifyBy, modifyDate, createBy, createDate));
                System.out.println(stocks.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stocks;
    }

    @Override
    public void save(Stock stock) {
        System.out.println(INSERT_STOCK_SQL);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STOCK_SQL);) {
            preparedStatement.setString(1, stock.getName());
            preparedStatement.setString(2, stock.getAddress());
            preparedStatement.setString(3, stock.getPhoneNumber());
            preparedStatement.setString(4, stock.getCreateBy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Stock findById(int id) {
        Stock stock = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STOCK_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStock = rs.getInt("idStock");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                String deleteBy = rs.getString("deleteBy");
                String deleteDate = rs.getString("deleteDate");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate = rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                stock = new Stock(idStock, name, address, phoneNumber, deleteBy, deleteDate, modifyBy, modifyDate, createBy, createDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return stock;
    }

    @Override
    public void update(int id, Stock stock) {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STOCK_SQL);) {
            statement.setString(1, stock.getName());
            statement.setString(2, stock.getAddress());
            statement.setString(3, stock.getPhoneNumber());
            statement.setString(4, stock.getModifyBy());
            statement.setInt(5, stock.getIdStock());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int id, Stock stock) {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_STOCK_SQL);) {
            statement.setString(1, stock.getDeleteBy());
            statement.setInt(2, stock.getIdStock());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Stock> findAllCuong() {
        return null;
    }
}

