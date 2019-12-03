package codegym;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import codegym.repository.ProductRepository;
import codegym.repository.ProductRepositoryImpl;
import codegym.service.ProductService;
import codegym.service.ProductServiceImpl;

@Configuration
public class AppConfiguration {
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductRepositoryImpl();
    }
}
