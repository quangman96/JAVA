package service;

import model.DetailExportOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailExportOrderJDBCServiceImpl implements DetailExportService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_DETAILEXPORTORDER = "SELECT export_order.idExportOrder, export_order.name as exportOrderName, phone.name, detail_export_order.phoneAmount, staff.name as staffName ,stock.name as stockName, store.name as storeName," +
            "detail_export_order.createBy, detail_export_order.createDate, detail_export_order.modifyBy, detail_export_order.modifyDate," +
            " detail_export_order.deleteBy, detail_export_order.deleteDate" +
            "FROM detail_export_order INNER JOIN export_order ON detail_export_order.idExportOrder = export_order.idExportOrder" +
            "INNER JOIN phone ON detail_export_order.idPhone = phone.idPhone" +
            "INNER JOIN staff ON export_order.idStaff = staff.idStaff" +
            "INNER JOIN stock ON export_order.idStock = stock.idStock" +
            "INNER JOIN store ON export_order.idStore = store.idStore" +
            "WHERE export_order.idExportOrder = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
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
    public List<DetailExportOrder> findAll() {
        List<DetailExportOrder> detailExportOrders = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAILEXPORTORDER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idExportOrder = rs.getInt("export_order.idExportOrder");
                String exportOrderName = rs.getString("export_order.name");
                String phoneName = rs.getString("phone.name");
                int phoneAmount = rs.getInt("detail_export_order.phoneAmount");
                String staffName = rs.getString("staff.name");
                String stockName = rs.getString("stock.name");
                String storeName = rs.getString("store.name");
                String createBy = rs.getString("detail_export_order.createBy");
                String createDate = rs.getString("detail_export_order.createDate");
                String modifyBy = rs.getString("detail_export_order.modifyBy");
                String modifyDate = rs.getString("detail_export_order.modifyDate");
                String deleteBy = rs.getString("detail_export_order.deleteBy");
                String deleteDate = rs.getString("detail_export_order.deleteDate");
                detailExportOrders.add(new DetailExportOrder(idExportOrder,exportOrderName,phoneName,phoneAmount,staffName,stockName,storeName,createBy,createDate,modifyBy,modifyDate,deleteBy,deleteDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return detailExportOrders;
    }

    @Override
    public DetailExportOrder findById(int id) {
//        List<DetailExportOrder> detailExportOrders = new ArrayList<>();
        DetailExportOrder detailExportOrder = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DETAILEXPORTORDER);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                int idExportOrder = rs.getInt("export_order.idExportOrder");
                String exportOrderName = rs.getString("export_order.name");
                String phoneName = rs.getString("phone.name");
                int phoneAmount = rs.getInt("detail_export_order.phoneAmount");
                String staffName = rs.getString("staff.name");
                String stockName = rs.getString("stock.name");
                String storeName = rs.getString("store.name");
                String createBy = rs.getString("detail_export_order.createBy");
                String createDate = rs.getString("detail_export_order.createDate");
                String modifyBy = rs.getString("detail_export_order.modifyBy");
                String modifyDate = rs.getString("detail_export_order.modifyDate");
                String deleteBy = rs.getString("detail_export_order.deleteBy");
                String deleteDate = rs.getString("detail_export_order.deleteDate");
                detailExportOrder = new DetailExportOrder(id,exportOrderName,phoneName,phoneAmount,staffName,stockName,storeName,createBy,createDate,modifyBy,modifyDate,deleteBy,deleteDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return detailExportOrder;
    }
}
