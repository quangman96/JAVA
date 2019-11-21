package service;


import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductServiceImpl {
    List<Product> findAll() throws SQLException;

    void save(Product product);

    Product findById(int id);

    void update (int id, Product product);

    void remove(int id);

}

