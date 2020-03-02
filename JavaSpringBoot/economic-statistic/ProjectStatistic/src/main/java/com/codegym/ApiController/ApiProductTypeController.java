package com.codegym.ApiController;

import com.codegym.model.ProductType;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiProductTypeController {
    @Autowired
    private ProductTypeService productTypeService;
    //-------------------Retrieve All ProductType--------------------------------------------------------

@RequestMapping(value = "/producttypes-list",method = RequestMethod.GET)
public ResponseEntity<List<ProductType>> listAllProduct() {
    List<ProductType> producttypes = (List<ProductType>) productTypeService.findAllProductType();
    if (producttypes.isEmpty()) {
        return new ResponseEntity<List<ProductType>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
    }
    return new ResponseEntity<List<ProductType>>(producttypes, HttpStatus.OK);
}

    //-------------------Retrieve Single ProducType--------------------------------------------------------

    @RequestMapping(value = "/producttype-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductType> getProductType(@PathVariable("id") long id) {
        System.out.println("Fetching ProductType with id " + id);
        ProductType productType = productTypeService.findId(id);
        if (productType == null) {
            System.out.println("ProductType with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productType, HttpStatus.OK);
    }
    //-------------------Create a ProductType--------------------------------------------------------

    @RequestMapping(value = "/producttype-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createProductType(@RequestBody ProductType productType, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating ProductType " + productType.getNameProductType());
        productTypeService.save(productType);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("producttype-create/{id}").buildAndExpand(productType.getIdProductType()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a ProductType --------------------------------------------------------

    @RequestMapping(value = "/producttype-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductType> updateProductType(@PathVariable("id") long id, @RequestBody ProductType productType) {
        System.out.println("Updating ProductType " + id);

        ProductType currentProductType = productTypeService.findId(id);

        if (currentProductType == null) {
            System.out.println("ProductType with id " + id + " not found");
            return new ResponseEntity<ProductType>(HttpStatus.NOT_FOUND);
        }

        currentProductType.setNameProductType(productType.getNameProductType());
        currentProductType.setIdProductType(productType.getIdProductType());

        productTypeService.save(currentProductType);
        return new ResponseEntity<ProductType>(currentProductType, HttpStatus.OK);
    }
    //------------------- Delete a ProductType --------------------------------------------------------

    @RequestMapping(value = "/producttype-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ProductType> deleteProductType(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting ProductType with id " + id);

        ProductType productType = productTypeService.findId(id);
        if (productType == null) {
            System.out.println("Unable to delete. ProductType with id " + id + " not found");
            return new ResponseEntity<ProductType>(HttpStatus.NOT_FOUND);
        }

        productTypeService.deletedProductType(id);
        return new ResponseEntity<ProductType>(productType, HttpStatus.NO_CONTENT);
    }



}
