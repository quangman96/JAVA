package service;

import model.Brand;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandJDBCServiceImpl implements BrandService {
    private String jdbcURL = "jdbc:mysql://localhost:3306/inventory_management";
    private String jdbcUsername = "codegym";
    private String jdbcPassword = "codegym.123";

    private static final String SELECT_ALL_BRANDS = "select * from brand where isDelete = 0";
    private static final String INSERT_BRAND_SQL  = "INSERT INTO brand (name, createBy) VALUES (?,?)";
    private static final String UPDATE_BRAND_SQL  ="UPDATE brand SET name = ?, modifyBy = ? WHERE (idBrand = ?);";
    private static final String SELECT_BRAND_BY_ID = "select * from brand WHERE (idBrand = ?);";
    private static final String DELETE_BRAND_SQL = "UPDATE brand SET isDelete = 1, deleteBy = ? WHERE (idBrand = ?);";
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
    public List<Brand> findAll() {
        List<Brand> brands = new ArrayList<>();
        try( Connection connection = getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_BRANDS);) {
                System.out.println(preparedStatement);
                ResultSet rs =preparedStatement.executeQuery();
                while(rs.next()){
                    int idBrand = rs.getInt("idBrand");
                    String name = rs.getString("name");
                    String deleteBy = rs.getString("deleteBy");
                    String deleteDate = rs.getString("deleteDate");
                    String modifyBy = rs.getString("modifyBy");
                    String modifyDate =rs.getString("modifyDate");
                    String createBy = rs.getString("createBy");
                    String createDate = rs.getString("createDate");
                    brands.add(new Brand(idBrand,name,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate));
                    System.out.println(brands.toString()); ;
            }
        }catch (SQLException e) {
            printSQLException(e);
        }
        return brands;
    }

    @Override
    public void save(Brand brand) {
        System.out.println(INSERT_BRAND_SQL);
        try(Connection connection =getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BRAND_SQL);){
            preparedStatement.setString(1,brand.getName());
            preparedStatement.setString(2,brand.getCreateBy());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

    }

    @Override
    public Brand findById(int id) {
        Brand brand = null;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BRAND_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idBrand = rs.getInt("idBrand");
                String name = rs.getString("name");
                String deleteBy = rs.getString("deleteBy");
                String deleteDate = rs.getString("deleteDate");
                String modifyBy = rs.getString("modifyBy");
                String modifyDate =rs.getString("modifyDate");
                String createBy = rs.getString("createBy");
                String createDate = rs.getString("createDate");
                brand = new Brand(idBrand,name,deleteBy,deleteDate,modifyBy,modifyDate,createBy,createDate);

            }
        }catch (SQLException e) {
            printSQLException(e);
        }
        return brand;
    }

    @Override
    public void update(int id, Brand brand) {
        boolean rowUpdated;
        try(Connection connection =getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_BRAND_SQL);){
            statement.setString(1, brand.getName());
            statement.setString(2, brand.getModifyBy());
            statement.setInt(3, brand.getIdBrand());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public void remove(int id, Brand brand) {
        boolean rowUpdated;
        try(Connection connection =getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_BRAND_SQL);){
            statement.setString(1, brand.getDeleteBy());
            statement.setInt(2, brand.getIdBrand());
            rowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {
            printSQLException(e);
        }

    }
}
