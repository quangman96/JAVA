package service;

import model.ImportOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImportOrderJDBCServiceImpl implements ImportOrderService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_IMPORTORDER = "SELECT \n" +
            "    import_order.idImportOrder,\n" +
            "    import_order.idStaff,\n" +
            "    import_order.idStock,\n" +
            "    import_order.name,\n" +
            "    import_order.deleteBy,\n" +
            "    import_order.deleteDate,\n" +
            "    import_order.modifyBy,\n" +
            "    import_order.modifyDate,\n" +
            "    import_order.createBy,\n" +
            "    import_order.createDate,\n" +
            "    staff.name AS staffName,\n" +
            "    stock.name AS stockName\n" +
            "FROM\n" +
            "    import_order\n" +
            "        JOIN\n" +
            "    staff ON import_order.idStaff = staff.idStaff\n" +
            "        JOIN\n" +
            "    stock ON import_order.idStock = stock.idStock\n" +
            "WHERE\n" +
            "    import_order.isDelete = 0\n" +
            "        AND stock.isDelete = 0\n" +
            "        AND staff.isDelete = 0;";

    private static final String INSERT_IMPORTORDER_SQL = "INSERT INTO import_order" + "(name,createBy, idStock, idStaff) VALUES" + "(?,?,?,?);";
    private static final String SELECT_IMPORTORDER_BY_ID = "SELECT \n" +
            "    import_order.idImportOrder,\n" +
            "    import_order.name,\n" +
            "    import_order.modifyBy,\n" +
            "    staff.name AS staffName,\n" +
            "    stock.name AS stockName\n" +
            "FROM\n" +
            "    import_order\n" +
            "        JOIN\n" +
            "    staff ON import_order.idStaff = staff.idStaff\n" +
            "        JOIN\n" +
            "    stock ON import_order.idStock = stock.idStock\n" +
            "WHERE\n" +
            "    idImportOrder = ?;";
    private static final String DLETE_IMPORTORDER_BY_ID_DEL = "delete from import_order where idImportOrder = ?;";
    private static final String DELETE_USERS_SQL = "SELECT \n" +
            "    import_order.idImportOrder,\n" +
            "    import_order.name,\n" +
            "    import_order.deleteBy,\n" +
            "    import_order.deleteDate,\n" +
            "    import_order.modifyBy,\n" +
            "    import_order.modifyDate,\n" +
            "    import_order.createBy,\n" +
            "    import_order.createDate,\n" +
            "    staff.name AS staffName,\n" +
            "    stock.name AS stockName\n" +
            "FROM\n" +
            "    import_order\n" +
            "        JOIN\n" +
            "    staff ON import_order.idStaff = staff.idStaff\n" +
            "        JOIN\n" +
            "    stock ON import_order.idStock = stock.idStock\n" +
            "WHERE\n" +
            "    idImportOrder = ?;";
    private static final String UPDATE_IMPORTORDER_SQL = "UPDATE import_order SET name = ?,  modifyBy = ? WHERE (idImportOrder = ?);";
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
    public List<ImportOrder> findAll() {
        List<ImportOrder> importOrders = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_IMPORTORDER);) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idImportOrder = rs.getInt("idImportOrder");
                String name = rs.getString("name");
                String staffName = rs.getString("staffName");
                String stockName = rs.getString("stockName");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                importOrders.add(new ImportOrder(idImportOrder, name, staffName, stockName, createBy, createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return importOrders;
    }

    @Override
    public void save(ImportOrder importOrder) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_IMPORTORDER_SQL)) {
            preparedStatement.setString(1, importOrder.getName());
            preparedStatement.setString(2, importOrder.getCreateBy());
            preparedStatement.setInt(3, importOrder.getIdStock());
            preparedStatement.setInt(4, importOrder.getIdStaff());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public ImportOrder findById(int id) {
        ImportOrder importOrder = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_IMPORTORDER_BY_ID);) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idImportOrder = rs.getInt("idImportOrder");
                String name = rs.getString("name");
                String staffName = rs.getString("staffName");
                String stockName = rs.getString("stockName");
                String modifyBy = rs.getString("modifyBy");
                importOrder = new ImportOrder(idImportOrder, name, staffName, stockName, modifyBy);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return importOrder;
    }

    @Override
    public ImportOrder findById_for_del(int id) {
        ImportOrder importOrder = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);) {
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idImportOrder = rs.getInt("idImportOrder");
                String name = rs.getString("name");
                String staffName = rs.getString("staffName");
                String stockName = rs.getString("stockName");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate = rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                String deleteBy = "";
                String deleteDate = "";
                importOrder = new ImportOrder(idImportOrder, name, staffName, stockName, deleteBy, deleteDate, modifyBy, modifyDate, createBy, createDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return importOrder;
    }


    @Override
    public void update(int id, ImportOrder importOrder) {
        boolean rowUpdated;
        try(Connection connection =getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_IMPORTORDER_SQL);){
            statement.setString(1,importOrder.getName());
            statement.setString(2,importOrder.getModifyBy());
            statement.setInt(3,importOrder.getIdImportOrder());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DLETE_IMPORTORDER_BY_ID_DEL);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
