package service;

import model.DetailExportOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailExportOrderJDBCServiceImpl {
    public static class DetailExportOrderJDBCService implements DetailExportOrderService {
        private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
        private String jdbcUsername = "codegym";
        private String jdbcPassword = "codegym.123";
        private static final String SELECT_ALL_STORE_BY_IDEXPORTORDER = "SELECT detail_export_order.idExportOrder, phone.name, detail_export_order.phoneAmount,detail_export_order.createBy,detail_export_order.createDate, detail_export_order.modifyBy,detail_export_order.modifyDate,staff.name,stock.name,store.name FROM detail_export_order inner join export_order on detail_export_order.idExportOrder = export_order.idExportOrder inner join phone on detail_export_order.idPhone = phone.idPhone inner join staff on export_order.idStaff = staff.idStaff inner join stock on export_order.idStock = stock.idStock inner join store on export_order.idStore = store.idStore where detail_export_order.idExportOrder = ?;";

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
        public List<DetailExportOrder> findByIDExportOrder(int idExportOrder) {
            List<DetailExportOrder> detailExportOrders = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STORE_BY_IDEXPORTORDER);) {
                preparedStatement.setInt(1, idExportOrder);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("detail_export_order.idExportOrder");
                    String phoneName = rs.getString("phone.name");
                    int PhoneAmount = rs.getInt("detail_export_order.phoneAmount");
                    String staffName = rs.getString("staff.name");
                    String stockName = rs.getString("stock.name");
                    String storeName = rs.getString("store.name");
                    String createBy = rs.getString("detail_export_order.createBy");
                    String createDate = rs.getString("detail_export_order.createDate");
                    String modifyBy = rs.getString("detail_export_order.modifyBy");
                    String modifyDate = rs.getString("detail_export_order.modifyDate");
                    detailExportOrders.add(new DetailExportOrder(id,phoneName,PhoneAmount,staffName,stockName,storeName,createBy,createDate,modifyBy,modifyDate));
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return detailExportOrders;
        }
    }
    }



