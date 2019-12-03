package codegym.repository;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository{

    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1,new Product(1,"ABC","Civic",5000));
        products.put(2,new Product(2,"QWE","Ferrari",40000));
        products.put(3,new Product(3,"ASD","Toyota",10000));
        products.put(4,new Product(4,"REF","Audi",30000));
        products.put(5,new Product(5,"TRG","Camry",20000));
    }

    @Override
    public List<Product> fillAll(){
        return new ArrayList<>(products.values());
    }

    @Override
    public Product fillById(int id){
        Product product = products.get(id);
        return product;
    }

    @Override
    public void save(Product product){
        products.put(product.getId(),product);
    }
}
