package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.server.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping()
    public List<Employee> find(){
        return employeeService.findAll();
    }

    @GetMapping(params = "minAge")
    public List<Employee> findLowerAge(@RequestParam(name = "minAge")int minAge){
        return employeeService.findAll(minAge);
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable int id){
        return employeeService.findById(id);
    }

    @PostMapping
    public List<Employee> createEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employeeService.employeeList;
    }

    @DeleteMapping(value = "/{id}")
    public List<Employee> deleteEmployee(@PathVariable("id") int id){
        employeeService.delete(id);
        return employeeService.employeeList;
    }

    @PutMapping
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee) ? employee : null;
    }


}
