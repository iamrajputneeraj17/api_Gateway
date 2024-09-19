package com.Employee.EmpData.controller;

import com.Employee.EmpData.entity.Employee;
import com.Employee.EmpData.service.empService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/db")
public class empController {
    @Autowired
    private empService service;

    @PostMapping("/create")
    public Employee create(@Valid @RequestBody Employee empData)
    {
        return service.createEmp(empData);
    }

    @GetMapping("/Employee")
    public List<Employee> allEmp()
    {
        return service.getAllEmp();
    }

    @GetMapping("/byName/{name}")
    public List<Employee> byName(@PathVariable("name") String name)
    {
        return service.getByName(name);
    }

    @GetMapping("/Employee/{id}")
    public ResponseEntity<?> empById(@PathVariable Integer id) {
        Employee employee = service.getById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
        } else {
            return ResponseEntity.ok(employee);
        }
    }
    @PutMapping("/Employee/update/{id}")
    public Employee update(@RequestBody Employee updateData, @PathVariable Integer id)
    {
        return service.update(updateData, id);
    }



//    public Employee empById(@PathVariable Integer id)
//    {
//        return service.getById(id);
//    }

}
