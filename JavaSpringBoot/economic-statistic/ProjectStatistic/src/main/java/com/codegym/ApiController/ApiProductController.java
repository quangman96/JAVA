package com.codegym.ApiController;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiProductController {

    @Autowired
    private ProductService productService;

    //-------------------Retrieve All Product--------------------------------------------------------

    @RequestMapping(value = "/products-list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProduct() {
        List<Product> products = (List<Product>) productService.findAllProduct();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    //-------------------Retrieve Single Product--------------------------------------------------------

    @RequestMapping(value = "/product-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
        System.out.println("Fetching Product with id " + id);
        Product product = productService.findId(id);
        if (product == null) {
            System.out.println("Product with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //-------------------Create a Product--------------------------------------------------------

   /* @RequestMapping(value = "/product-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createProduct(@RequestBody List<Product> products,Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getNameProduct());
        for (Product pro:products
             ) {productService.save(product);
         products.add(pro);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product-create/{id}").buildAndExpand(product.getIdProduct()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }*/
/*@RequestMapping(value = "/product-create", method = RequestMethod.POST)
    public <Void> createProduct(@RequestBody List<Product> products,Product product, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Product " + product.getNameProduct());
        for (Product pro:products
             ) {productService.save(product);
         products.add(pro);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product-create/{id}").buildAndExpand(product.getIdProduct()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }*/



    //------------------- Update a Product --------------------------------------------------------

       @RequestMapping(value = "/product-edit/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Product> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
            System.out.println("Updating Product " + id);

            Product currentProduct = productService.findId(id);

            if (currentProduct == null) {
                System.out.println("Product with id " + id + " not found");
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }

           currentProduct.setNameProduct(product.getNameProduct());
           currentProduct.setProducttype(product.getProducttype());
           currentProduct.setUnit(product.getUnit());
           currentProduct.setIsDeleted(product.getIsDeleted());
           currentProduct.setIdProduct(product.getIdProduct());
            productService.save(currentProduct);
            return new ResponseEntity<Product>(currentProduct, HttpStatus.OK);
        }

        //------------------- Delete a Product --------------------------------------------------------

        @RequestMapping(value = "/product-delete/{id}", method = RequestMethod.PUT)
        public ResponseEntity<Product> deleteProduct(@PathVariable("id") long id) {
            System.out.println("Fetching & Deleting Product with id " + id);

            Product product = productService.findId(id);
            if (product == null) {
                System.out.println("Unable to delete. Product with id " + id + " not found");
                return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
            }

            productService.deletedProduct(id);
            return new ResponseEntity<Product>(product, HttpStatus.NO_CONTENT);
        }


}
