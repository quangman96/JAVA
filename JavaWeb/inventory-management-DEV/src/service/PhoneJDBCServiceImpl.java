package service;

import model.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhoneJDBCServiceImpl implements PhoneService {

    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_PHONES = "SELECT *FROM phone inner join brand on brand.idBrand = phone.idBrand where phone.isDelete = 0 and brand.isDelete = 0;";
    private static final String SELECT_PHONE_BY_IDBRAND = "SELECT *FROM phone inner join brand on brand.idBrand = phone.idBrand where phone.isDelete = 0 and brand.isDelete = 0 and phone.idBrand = ?;";
    private static final String SELECT_PHONE_BY_ID = "select * from phone inner join brand on brand.idBrand = phone.idBrand  WHERE (idPhone = ?);";
    private static final String DELETE_PHONE_SQL = "UPDATE phone SET isDelete = 1, deleteBy = ? WHERE (idPhone = ?);";
    private static final String UPDATE_PHONE_SQL = "UPDATE phone SET name = ?, amount = ?, information = ?, image = ?, modifyBy = ? WHERE (idPhone = ?);";
    private static final String INSERT_PHONE_SQL = "INSERT INTO phone (name, amount, information, image, idBrand, createBy) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String FIND = "SELECT *FROM phone inner join brand on brand.idBrand = phone.idBrand where phone.isDelete = 0 and brand.isDelete = 0 and phone.name like ?";
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
    public List<Phone> findAll() {
        List<Phone>phones = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PHONES);){
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idPhone =rs.getInt("idPhone");
                String phoneName = rs.getString("phone.name");
                int amount = rs.getInt("amount");
                String information = rs.getString("information");
                String image = rs.getString("image");
                String brandName = rs.getString("brand.name");
                String createBy = rs.getString("phone.createBy");
                String deleteBy = rs.getString("phone.deleteBy");
                String deleteDate = rs.getString("phone.deleteDate");
                String modifyBy = rs.getString("phone.modifyBy");
                String modifyDate = rs.getString("phone.modifyDate");
                String createDate = rs.getString("phone.createDate");
                phones.add(new Phone(idPhone,phoneName,amount,information,image,brandName,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phones;


    }

    @Override
    public List<Phone> findByName(String inputValue) {
        List<Phone>phones = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND);){
            preparedStatement.setString(1,"%"+ inputValue+"%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idPhone =rs.getInt("idPhone");
                String phoneName = rs.getString("phone.name");
                int amount = rs.getInt("amount");
                String information = rs.getString("information");
                String image = rs.getString("image");
                String brandName = rs.getString("brand.name");
                String createBy = rs.getString("phone.createBy");
                String deleteBy = rs.getString("phone.deleteBy");
                String deleteDate = rs.getString("phone.deleteDate");
                String modifyBy = rs.getString("phone.modifyBy");
                String modifyDate = rs.getString("phone.modifyDate");
                String createDate = rs.getString("phone.createDate");
                phones.add(new Phone(idPhone,phoneName,amount,information,image,brandName,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phones;


    }

    @Override
    public void save(Phone phone) {
        System.out.println(INSERT_PHONE_SQL);
        try(Connection connection =getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE_SQL);){
            preparedStatement.setString(1,phone.getName());
            preparedStatement.setInt(2,phone.getAmount());
            preparedStatement.setString(3,phone.getInformation());
            preparedStatement.setString(4,phone.getImage());
            preparedStatement.setInt(5,phone.getIdBrand());
            preparedStatement.setString(6,phone.getCreateBy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Phone findById(int id) {
        Phone phone = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONE_BY_ID);){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idPhone =rs.getInt("idPhone");
                String phoneName = rs.getString("phone.name");
                int amount = rs.getInt("amount");
                String information = rs.getString("information");
                String image = rs.getString("image");
                String brandName = rs.getString("brand.name");
                String createBy = rs.getString("phone.createBy");
                String deleteBy = rs.getString("phone.deleteBy");
                String deleteDate = rs.getString("phone.deleteDate");
                String modifyBy = rs.getString("phone.modifyBy");
                String modifyDate = rs.getString("phone.modifyDate");
                String createDate = rs.getString("phone.createDate");
                phone = new Phone(idPhone,phoneName,amount,information,image,brandName,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phone;
    }

    @Override
    public void update(int id, Phone phone) {
        boolean rowUpdated;
        try(Connection connection =getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_PHONE_SQL);){
            statement.setString(1, phone.getName());
            statement.setInt(2,phone.getAmount());
            statement.setString(3, phone.getInformation());
            statement.setString(4, phone.getImage());
            statement.setString(5, phone.getModifyBy());
            statement.setInt(6, phone.getIdPhone());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int id, Phone phone) {
        boolean rowUpdated;
        try(Connection connection =getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PHONE_SQL);){
            statement.setString(1, phone.getDeleteBy());
            statement.setInt(2, phone.getIdPhone());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public List<Phone> findAllByIdBrand(int id) {
        List<Phone>phones = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PHONE_BY_IDBRAND);){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int idPhone =rs.getInt("idPhone");
                String phoneName = rs.getString("phone.name");
                int amount = rs.getInt("amount");
                String information = rs.getString("information");
                String image = rs.getString("image");
                String brandName = rs.getString("brand.name");
                String createBy = rs.getString("phone.createBy");
                String deleteBy = rs.getString("phone.deleteBy");
                String deleteDate = rs.getString("phone.deleteDate");
                String modifyBy = rs.getString("phone.modifyBy");
                String modifyDate = rs.getString("phone.modifyDate");
                String createDate = rs.getString("phone.createDate");
                phones.add(new Phone(idPhone,phoneName,amount,information,image,brandName,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return phones;
    }
}
