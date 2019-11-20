package service;

import model.DetailImportOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailImportOrderJDBCServletImpl{
    public static class DetailImportOrderJDBCServiceImpl implements DetailImportOrderService {
        private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
        private String jdbcUsername = "codegym";
        private String jdbcPassword = "codegym.123";
        private static final String SELECT_ALL_STORE_BY_IDIMPORTORDER = "select * from phone inner join detail_import_order on phone.idPhone = detail_import_order.idPhone inner join import_order on import_order.idImportOrder = detail_import_order.idImportorder where detail_import_order.idImportOrder =?;";

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
        public List<DetailImportOrder> findByIDImportOrder(int idImportOrder) {
            List<DetailImportOrder> detailImportOrders = new ArrayList<>();
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STORE_BY_IDIMPORTORDER);) {
                preparedStatement.setInt(1, idImportOrder);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String namephone = rs.getString("phone.name");
                    String nameImportOrder = rs.getString("import_order.name");
                    Integer PhoneAmount = rs.getInt("detail_import_order.phoneAmount");
                    detailImportOrders.add(new DetailImportOrder(idImportOrder, PhoneAmount, nameImportOrder, namephone));
                    System.out.println(detailImportOrders.toString());
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return detailImportOrders;
        }
    }
}
