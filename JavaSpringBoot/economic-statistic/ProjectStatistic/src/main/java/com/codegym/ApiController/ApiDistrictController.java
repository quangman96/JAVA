package com.codegym.ApiController;

import com.codegym.model.District;
import com.codegym.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiDistrictController {
    @Autowired
    private DistrictService districtService;

    //-------------------Retrieve All District--------------------------------------------------------

    @RequestMapping(value = "/districts-list", method = RequestMethod.GET)
    public ResponseEntity<List<District>> listAllDistrict() {
        List<District> districts = (List<District>) districtService.findAllDistrict();
        if (districts.isEmpty()) {
            return new ResponseEntity<List<District>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<District>>(districts, HttpStatus.OK);
    }

    //-------------------Retrieve Single District--------------------------------------------------------

    @RequestMapping(value = "/district-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<District> getDistrict(@PathVariable("id") long id) {
        System.out.println("Fetching District with id " + id);
        District district = districtService.findId(id);
        if (district == null) {
            System.out.println("District with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(district, HttpStatus.OK);
    }

    //-------------------Create a District--------------------------------------------------------

    @RequestMapping(value = "/district-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDistrict(@RequestBody District district, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating District " + district.getNameDistrict());
        districtService.save(district);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/district-create/{id}").buildAndExpand(district.getIdDistrict()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a District --------------------------------------------------------

    @RequestMapping(value = "/district-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<District> updateDistrict(@PathVariable("id") long id, @RequestBody District district) {
        System.out.println("Updating District " + id);

        District currentDistrict = districtService.findId(id);

        if (currentDistrict == null) {
            System.out.println("District with id " + id + " not found");
            return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
        }

        currentDistrict.setNameDistrict(district.getNameDistrict());
        currentDistrict.setIdDistrict(district.getIdDistrict());
        districtService.save(currentDistrict);
        return new ResponseEntity<District>(currentDistrict, HttpStatus.OK);
    }

    //------------------- Delete a District --------------------------------------------------------

    @RequestMapping(value = "/district-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<District> deleteDistrict(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting District with id " + id);

        District district = districtService.findId(id);
        if (district == null) {
            System.out.println("Unable to delete. Product with id " + id + " not found");
            return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
        }

        districtService.deletedDistrict(id);
        return new ResponseEntity<District>(district, HttpStatus.NO_CONTENT);
    }

}
