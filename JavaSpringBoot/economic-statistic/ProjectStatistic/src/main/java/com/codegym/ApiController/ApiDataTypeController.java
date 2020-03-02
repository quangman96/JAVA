package com.codegym.ApiController;

import com.codegym.model.DataType;
import com.codegym.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiDataTypeController {
    @Autowired
    private DataTypeService dataTypeService;

    //-------------------Retrieve All DatatType--------------------------------------------------------

    @RequestMapping(value = "/datatype-list",method = RequestMethod.GET)
    public ResponseEntity<List<DataType>> listAllDataType() {
        List<DataType> dataTypes = (List<DataType>) dataTypeService.findAllDataType();
        if (dataTypes.isEmpty()) {
            return new ResponseEntity<List<DataType>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<DataType>>(dataTypes, HttpStatus.OK);
    }

    //-------------------Retrieve Single Datatypes -------------------------------------------------------

    @RequestMapping(value = "/datatype-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DataType> getDatatype(@PathVariable("id") long id) {
        System.out.println("Fetching DataType with id " + id);
        DataType dataType = dataTypeService.findId(id);
        if (dataType == null) {
            System.out.println("DataType with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(dataType, HttpStatus.OK);
    }

    //-------------------Create a DataType--------------------------------------------------------

    @RequestMapping(value = "/datatype-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDataType(@RequestBody DataType dataType, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating DataType " + dataType.getNameDataType());
        dataTypeService.save(dataType);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/datatype-create/{id}").buildAndExpand(dataType.getIdDataType()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a DataType --------------------------------------------------------

    @RequestMapping(value = "/datatype-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataType> updateDataType(@PathVariable("id") long id, @RequestBody DataType dataType) {
        System.out.println("Updating DataType " + id);

        DataType currentDatatype = dataTypeService.findId(id);

        if (currentDatatype == null) {
            System.out.println("DataType with id " + id + " not found");
            return new ResponseEntity<DataType>(HttpStatus.NOT_FOUND);
        }

        currentDatatype.setNameDataType(dataType.getNameDataType());
        currentDatatype.setIdDataType(dataType.getIdDataType());

        dataTypeService.save(currentDatatype);
        return new ResponseEntity<DataType>(currentDatatype, HttpStatus.OK);
    }

    //------------------- Delete a DataType --------------------------------------------------------

    @RequestMapping(value = "/datatype-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<DataType> deleteDataType(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting DataType with id " + id);

        DataType dataType = dataTypeService.findId(id);
        if (dataType == null) {
            System.out.println("Unable to delete. DataType with id " + id + " not found");
            return new ResponseEntity<DataType>(HttpStatus.NOT_FOUND);
        }

        dataTypeService.deletedDataType(id);
        return new ResponseEntity<DataType>(dataType, HttpStatus.NO_CONTENT);
    }
}
