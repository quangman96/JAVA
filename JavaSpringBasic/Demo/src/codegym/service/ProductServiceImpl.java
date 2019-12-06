package codegym.service;

import codegym.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import codegym.repository.ProductRepository;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Override
    public List<Product> fillAll(){
        return this.productRepository.fillAll();
    }

    @Override
    public Product fillById(int id){
        return this.productRepository.fillById(id);
    }

    @Override
    public void save(Product product){
        this.productRepository.save(product);
    }
}
