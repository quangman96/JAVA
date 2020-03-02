package com.codegym.ApiController;

import com.codegym.model.DataProduct;
import com.codegym.service.DataProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiDataProductController {
    @Autowired
    private DataProductService dataProductService;

    //-------------------Retrieve All DataProduct--------------------------------------------------------

    @RequestMapping(value = "/dataproduct-list", method = RequestMethod.GET)
    public ResponseEntity<List<DataProduct>> listAllDataProduct() {
        List<DataProduct> dataProducts = (List<DataProduct>) dataProductService.findAllDataProduct();
        if (dataProducts.isEmpty()) {
            return new ResponseEntity<List<DataProduct>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DataProduct>>(dataProducts, HttpStatus.OK);
    }

    //-------------------Retrieve Single DataProduct--------------------------------------------------------

    @RequestMapping(value = "/dataproduct-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataProduct> getDataProduct(@PathVariable("id") long id) {
        System.out.println("Fetching DataProduct with id " + id);
        DataProduct dataProduct = dataProductService.findId(id);
        if (dataProduct == null) {
            System.out.println("DataProduct with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataProduct, HttpStatus.OK);
    }

    //-------------------Create a DataProduct--------------------------------------------------------

    @RequestMapping(value = "/dataproduct-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDataProduct(@RequestBody DataProduct dataProduct, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating DataProduct " + dataProduct.getNameData());
        dataProductService.save(dataProduct);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/dataproduct-create/{id}").buildAndExpand(dataProduct.getIdData()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a DataProduct --------------------------------------------------------

    @RequestMapping(value = "/dataproduct-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataProduct> updateDataProduct(@PathVariable("id") long id, @RequestBody DataProduct dataProduct) {
        System.out.println("Updating District " + id);

        DataProduct currentDataProduct = dataProductService.findId(id);

        if (currentDataProduct == null) {
            System.out.println("DataProduct with id " + id + " not found");
            return new ResponseEntity<DataProduct>(HttpStatus.NOT_FOUND);
        }

        currentDataProduct.setNameData(dataProduct.getNameData());
        currentDataProduct.setIdData(dataProduct.getIdData());
        dataProductService.save(currentDataProduct);
        return new ResponseEntity<DataProduct>(currentDataProduct, HttpStatus.OK);
    }

    //------------------- Delete a DataProduct --------------------------------------------------------

    @RequestMapping(value = "/dataproduct-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataProduct> deleteDataProduct(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting DataProduct with id " + id);

        DataProduct dataProduct = dataProductService.findId(id);
        if (dataProduct == null) {
            System.out.println("Unable to delete. DataProduct with id " + id + " not found");
            return new ResponseEntity<DataProduct>(HttpStatus.NOT_FOUND);
        }

        dataProductService.deletedDataProduct(id);
        return new ResponseEntity<DataProduct>(dataProduct, HttpStatus.NO_CONTENT);
    }

}
