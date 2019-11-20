package service;

import model.Store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreJBDCServiceImpl implements StoreService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_STORE = "SELECT idStore, name, address, phoneNumber,deleteBy," +
            "deleteDate,modifyBy,modifyDate,createBy,createDate FROM store where isDelete = 0";
    private static final String SELECT_USER_BY_IDSTORE = "SELECT idStore, name, address, phoneNumber,deleteBy," +
            "deleteDate,modifyBy,modifyDate,createBy,createDate FROM store where idStore = ?";
    private static final String INSERT_STORE = "INSERT INTO store" + " ( name, address,phoneNumber,createBy) VALUES "
            + " (?, ?, ?, ?);";
    private static final String UPDATE_STORE = "UPDATE store SET name = ?, address = ?, phoneNumber = ?, modifyBy = ? where idStore = ?;";
    private static final String REMOVE_STORE_ISDELETE = "UPDATE store set isDelete ='1',deleteBy = ? WHERE idStore = ?;";

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
    public List<Store> findallStore() {
        List<Store> storeslist = new ArrayList<>();
        try (Connection connection = getConnection()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STORE)) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    int idStore = rs.getInt("idStore");
                    String nameStore = rs.getString("name");
                    String addressStore = rs.getString("address");
                    String PhoneNumberStore = rs.getString("PhoneNumber");
                    String deleteBy = rs.getString("deleteBy");
                    String deleteDate = rs.getString("deleteDate");
                    String modifyBy = rs.getString("modifyBy");
                    String modifyDate = rs.getString("modifyDate");
                    String createBy = rs.getString("createBy");
                    String createDate = rs.getString("createDate");
                    storeslist.add(new Store(idStore, nameStore, addressStore, PhoneNumberStore, deleteBy, deleteDate, modifyBy
                            , modifyDate, createBy, createDate));
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return storeslist;
    }

    @Override
    public Store findByIdStore(int idStore) {
        Store store = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_IDSTORE);) {
            preparedStatement.setInt(1, idStore);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String nameStore = rs.getString("name");
                String addressStore = rs.getString("address");
                String PhoneNumberStore = rs.getString("PhoneNumber");
                String deleteBy = rs.getString("deleteBy");
                String deleteDate = rs.getString("deleteDate");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate = rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                store = (new Store(idStore, nameStore, addressStore, PhoneNumberStore, deleteBy, deleteDate, modifyBy
                        , modifyDate, createBy, createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return store;
    }


    @Override
    public void saveStore(Store store) {
        System.out.println(INSERT_STORE);
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STORE)) {
            preparedStatement.setString(1, store.getNameStore());
            preparedStatement.setString(2, store.getAddressStore());
            preparedStatement.setString(3, store.getPhoneNumberStore());
            preparedStatement.setString(4, store.getCreatBy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    @Override
    public void updateStore(int idStore, Store store) {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_STORE);) {
            statement.setString(1, store.getNameStore());
            statement.setString(2, store.getAddressStore());
            statement.setString(3, store.getPhoneNumberStore());
            statement.setString(4, store.getModifyBy());
            statement.setInt(5, store.getIdStore());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public void removeStore(int idStore, String deleteBy) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(REMOVE_STORE_ISDELETE);) {
            statement.setInt(2, idStore);
            statement.setString(1, deleteBy);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
