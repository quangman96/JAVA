package com.codegym.ApiController;

import com.codegym.model.Province;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@ComponentScan("com.codegym")
@RestController
public class ApiProvinceController {
    @Autowired
    private ProvinceService provinceService;

    //-------------------Retrieve All Province--------------------------------------------------------

    @RequestMapping(value = "/province-list", method = RequestMethod.GET)
    public ResponseEntity<List<Province>> listAllProvince() {
        List<Province> provinces = (List<Province>) provinceService.findAll();
        if (provinces.isEmpty()) {
            return new ResponseEntity<List<Province>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Province>>(provinces, HttpStatus.OK);
    }

    //-------------------Retrieve Single Province -------------------------------------------------------

    @RequestMapping(value = "/province-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Province> getProvince(@PathVariable("id") long id) {
        System.out.println("Fetching Province with id " + id);
        Province province = provinceService.findId(id);
        if (province == null) {
            System.out.println("Province with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(province, HttpStatus.OK);
    }

    //-------------------Create a Province--------------------------------------------------------

    @RequestMapping(value = "/province-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createProvince(@RequestBody List<Province> provinces) {
        for (Province p : provinces) {
            provinceService.save(p);
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a Province --------------------------------------------------------

    @RequestMapping(value = "/province-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Province> updateProvince(@PathVariable("id") long id, @RequestBody Province province) {
        System.out.println("Updating Province " + id);

        Province currentProvince = provinceService.findId(id);

        if (currentProvince == null) {
            System.out.println("Province with id " + id + " not found");
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }

        currentProvince.setNameProvince(province.getNameProvince());
        currentProvince.setIdProvince(province.getIdProvince());

        provinceService.save(currentProvince);
        return new ResponseEntity<Province>(currentProvince, HttpStatus.OK);
    }

    //------------------- Delete a Province --------------------------------------------------------

    @RequestMapping(value = "/province-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Province> deleteProvince(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Province with id " + id);

        Province province = provinceService.findId(id);
        if (province == null) {
            System.out.println("Unable to delete. Province with id " + id + " not found");
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }

        provinceService.deletedProvince(id);
        return new ResponseEntity<Province>(province, HttpStatus.NO_CONTENT);
    }

}
