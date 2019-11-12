package service;

import model.ExportOrder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

public class ExportOrderJDBCServiceImpl implements ExportServiceImpl {
    private String jdbcURL = "jdbc:mysql//localhost:3306/inventory_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "manmeo96";

    private static final String INSERT_USER_SQL = "INSERT INTO export_order " + "(name,createBy) VALUES"
            + "(?,?);";
    private static final String SELECT_USER_BY_IDEXPORTORDER = "SELECT idExportOrder,name,exportDate,createBy form export_order WHERE idExportOrder = ?; ";
    private static final String SELECT_ALL_EXPORTORDER = "SELECT idExportOrder,name,exportDate,createBy FORM export_order ;";
    private static final String DELETE_USER_SQL = "DELETE FROM export_order WHERE idExportOrder = ?;";
    private static final String UPDATE_USER_SQL = "UPDATE export_order SET name=?,modifyBy=? WHERE idExportOrder = ?;";

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
    public List<ExportOrder> findAll() {
        List<ExportOrder> users = new ArrayList<>();
       try( Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EXPORTORDER);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int idExportOrder = rs.getInt("idExportOrder");
                String name = rs.getString("name");
                String createBy = rs.getString("createBy");
                users.add(new ExportOrder(idExportOrder,name,createBy));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public void save (ExportOrder exportOrder){
        System.out.println("INSERT_USER_SQL");
        try(Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL)) {
            preparedStatement.setString(1,exportOrder.getName());
            preparedStatement.setString(2,exportOrder.getCreateBy());
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    @Override
//    idExportOrder,name,exportDate,createBy
    public ExportOrder findById(int idExportOrder) {
        ExportOrder exportOrder = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_IDEXPORTORDER);) {
            preparedStatement.setInt(1, idExportOrder);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("name");
                int id = rs.getInt("idExportOrder");
                String exportDate = rs.getString("exportDate");
                String createBy = rs.getString("createBy");
                exportOrder = new ExportOrder(id, name, createBy);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return exportOrder;
    }


    @Override
    public void update(int idExportOrder, ExportOrder exportOrder){
        boolean rowUpdate;
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {

            statement.setString(1,exportOrder.getName());
            statement.setString(2,exportOrder.getModifyBy());
            statement.setInt(3,exportOrder.getIdExportOrder());

            rowUpdate = statement.executeUpdate()>0;
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int idExportOrder){
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);){
            statement.setInt(1,idExportOrder);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}


