package com.codegym.ApiController;

import com.codegym.model.Department;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class ApiDepartmentController {
    @Autowired
    private DepartmentService departmentService;

    //-------------------Retrieve All Department--------------------------------------------------------

    @RequestMapping(value = "/department-list",method = RequestMethod.GET)
    public ResponseEntity<List<Department>> listAllDepartment() {
        List<Department> departments = (List<Department>) departmentService.findAllDepartment();
        if (departments.isEmpty()) {
            return new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }

    //-------------------Retrieve Single Province -------------------------------------------------------

    @RequestMapping(value = "/department-find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Department> getDepartment(@PathVariable("id") long id) {
        System.out.println("Fetching Department with id " + id);
        Department department = departmentService.findId(id);
        if (department == null) {
            System.out.println("Department with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    //-------------------Create a Department--------------------------------------------------------

    @RequestMapping(value = "/department-create", method = RequestMethod.POST)
    public ResponseEntity<Void> createDepartment(@RequestBody Department department, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Department " + department.getNameDepartment());
        departmentService.save(department);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/department-create/{id}").buildAndExpand(department.getIdDepartment()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    //------------------- Update a Department --------------------------------------------------------

    @RequestMapping(value = "/department-edit/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long id, @RequestBody Department department) {
        System.out.println("Updating Department " + id);

        Department currentDepartment = departmentService.findId(id);

        if (currentDepartment == null) {
            System.out.println("Department with id " + id + " not found");
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }

        currentDepartment.setNameDepartment(department.getNameDepartment());
        currentDepartment.setIdDepartment(department.getIdDepartment());

        departmentService.save(currentDepartment);
        return new ResponseEntity<Department>(currentDepartment, HttpStatus.OK);
    }

    //------------------- Delete a Department --------------------------------------------------------

    @RequestMapping(value = "/department-delete/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Department> deleteDepartment(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Department with id " + id);

        Department department = departmentService.findId(id);
        if (department == null) {
            System.out.println("Unable to delete. Department with id " + id + " not found");
            return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
        }
        departmentService.deletedDepartment(id);
        return new ResponseEntity<Department>(department, HttpStatus.NO_CONTENT);
    }
}
