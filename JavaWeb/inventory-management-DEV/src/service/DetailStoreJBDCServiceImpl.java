package service;

import model.DetailStore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DetailStoreJBDCServiceImpl {
    public static class DetailStoreJDBCServiceImpl implements DetailStoreService {
        private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
        private String jdbcUsername = "codegym";
        private String jdbcPassword = "codegym.123";
        private static final String SELECT_ALL_DETAILSTORE = "select idStore,idPhone,phoneAmount from detail_store where isDelete = 0";
        private static final String SELECT_ALL_STORE_BY_IDSTORE ="select * from phone inner join detail_store on phone.idPhone = detail_store.idPhone inner join store on store.idStore = detail_store.idStore where detail_store.idStore =?;";
        private static final String SELECT_ALL_AMOUNT_BY_ID = "select sum(phoneAmount) FROM detail_store where idPhone = ?";
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
        public List<DetailStore> findalldetailStore() {
            List<DetailStore> detailStores = new ArrayList<>();
            try(Connection connection = getConnection();
                PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_DETAILSTORE);) {
                System.out.println(preparedStatement);
                ResultSet rs =preparedStatement.executeQuery();
                while(rs.next()){
                    int idStore = rs.getInt("idStore");
                    int idPhone = rs.getInt("idPhone");
                    String PhoneAmount = rs.getString("phoneAmount");
                    detailStores.add(new DetailStore(idStore,idPhone,PhoneAmount));
                    System.out.println(detailStores.toString()); ;
                }
            }catch (SQLException e) {
                printSQLException(e);
            }
            return detailStores;
        }

        @Override
        public List<DetailStore> findByIDStore(int idStore) {
            List<DetailStore> detailStores = new ArrayList<>();
            try(Connection connection = getConnection();
                PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_STORE_BY_IDSTORE);) {
                preparedStatement.setInt(1,idStore);
                System.out.println(preparedStatement);
                ResultSet rs =preparedStatement.executeQuery();
                while(rs.next()){
                    String namephone = rs.getString("phone.name");
                    String nameStore =rs.getString("store.name");
                    String PhoneAmount = rs.getString("detail_store.phoneAmount");
                    detailStores.add(new DetailStore(PhoneAmount,nameStore,namephone));
                    System.out.println(detailStores.toString());
                }
            }catch (SQLException e) {
                printSQLException(e);
            }
            return detailStores;
        }

        @Override
        public int AmoutPhoneByID(int id) {
            int amount = 0;
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_AMOUNT_BY_ID);) {
                preparedStatement.setInt(1, id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    amount = rs.getInt("sum(phoneAmount)");
                    System.out.println(amount);
                }
            } catch (SQLException e) {
                printSQLException(e);
            }
            return amount;
        }
    }
}
