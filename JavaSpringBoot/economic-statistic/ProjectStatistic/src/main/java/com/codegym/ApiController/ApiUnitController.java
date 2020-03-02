package com.codegym.ApiController;

import com.codegym.model.Unit;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiUnitController {
    @Autowired
    private UnitService unitService;

    //-------------------Retrieve All Unit--------------------------------------------------------

    @RequestMapping(value = "/unit-list",method = RequestMethod.GET)
    public ResponseEntity<List<Unit>> listAllUnit() {
        List<Unit> units = (List<Unit>) unitService.findAllUnit();
        if (units.isEmpty()) {
            return new ResponseEntity<List<Unit>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Unit>>(units, HttpStatus.OK);
    }

    //-------------------Retrieve Single Unit--------------------------------------------------------

    @RequestMapping(value = "/unit-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Unit> getUnit(@PathVariable("id") long id) {
        System.out.println("Fetching Product with id " + id);
        Unit unit = unitService.findId(id);
        if (unit == null) {
            System.out.println("Unit with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(unit, HttpStatus.OK);
    }

    //-------------------Create a Unit--------------------------------------------------------

    @RequestMapping(value = "/unit-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUnit(@RequestBody List<Unit> units) {
        for(Unit u: units){
            unitService.save(u);
        }
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a Unit --------------------------------------------------------

    @RequestMapping(value = "/unit-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Unit> updateUnit(@PathVariable("id") long id, @RequestBody Unit unit) {
        System.out.println("Updating Unit " + id);

        Unit currentUnit = unitService.findId(id);

        if (currentUnit == null) {
            System.out.println("UNit with id " + id + " not found");
            return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
        }

        currentUnit.setNameUnit(unit.getNameUnit());
        currentUnit.setIdUnit(unit.getIdUnit());

        unitService.save(currentUnit);
        return new ResponseEntity<Unit>(currentUnit, HttpStatus.OK);
    }

    //------------------- Delete a Unit --------------------------------------------------------

    @RequestMapping(value = "/unit-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Unit> deleteUnit(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Unit with id " + id);

        Unit unit = unitService.findId(id);
        if (unit == null) {
            System.out.println("Unable to delete. Unit with id " + id + " not found");
            return new ResponseEntity<Unit>(HttpStatus.NOT_FOUND);
        }

        unitService.deletedUnit(id);
        return new ResponseEntity<Unit>(unit, HttpStatus.NO_CONTENT);
    }

}
