package codegym.repository;

import codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> fillAll();

    Product fillById(int id);

    void save (Product product);
}
