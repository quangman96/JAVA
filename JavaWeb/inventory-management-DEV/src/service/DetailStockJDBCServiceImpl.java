package service;

import model.DetailStock;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailStockJDBCServiceImpl implements DetailStockService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_DETAILSTOCKS = "select idStock,idPhone,phoneAmount from detail_stock where isDelete = 0";
    private static final String SELECT_ALL_STOCK_BY_ID = "select * from phone inner join detail_stock on phone.idPhone " +
        "= detail_stock.idPhone inner join stock on stock.idStock = detail_stock.idStock where detail_stock.idStock =?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //TODO Auto-generated catch block
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
    public List<DetailStock> findAll() {
        List<DetailStock> detailStocks = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAILSTOCKS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idStock = rs.getInt("idStock");
                int idPhone = rs.getInt("idPhone");
                int phoneAmount = rs.getInt("phoneAmount");
                detailStocks.add(new DetailStock(idStock, idPhone, phoneAmount));
                System.out.println(detailStocks.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detailStocks;
    }

    @Override
    public List<DetailStock> findByIdStock(int idStock) {
        List<DetailStock> detailStocks = new ArrayList<>();;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STOCK_BY_ID);) {
            preparedStatement.setInt(1, idStock);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String namephone = rs.getString("phone.name");
                String nameStock = rs.getString("stock.name");
                int phoneAmount = rs.getInt("detail_stock.phoneAmount");
                detailStocks.add(new DetailStock(phoneAmount, nameStock, namephone));
                System.out.println(detailStocks.toString());
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return detailStocks;
    }

    @Override
    public int AmoutPhoneByID(int id) {
        return 0;
    }
}