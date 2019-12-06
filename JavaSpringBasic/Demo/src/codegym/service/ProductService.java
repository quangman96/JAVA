package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> fillAll();

    Product fillById(int id);

    void save(Product product);
}
