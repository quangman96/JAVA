

package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl {

    private List<Product> products;

    public ProductServiceImpl() {
        this.products = new ArrayList<>();
        products.add( new Product(1, "Dog", 200000, "dog.jpg"));
        products.add( new Product(2, "Cat", 100000, "dog.jpg"));
        products.add( new Product(3, "Mouse", 50000, "dog.jpg"));
        products.add( new Product(4, "Panda", 500000, "dog.jpg"));
        products.add( new Product(5, "Monkey", 400000, "dog.jpg"));
        products.add( new Product(6, "Turtle", 300000, "dog.jpg"));
    }

    public Product findById(int id) {
        for (Product product : this.products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return this.products;
    }


}
