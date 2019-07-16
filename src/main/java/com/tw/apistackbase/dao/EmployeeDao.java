package com.tw.apistackbase.dao;

import com.tw.apistackbase.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(int employeeId);
    List<Employee> findAll();
    boolean update(Employee employee);
    boolean delete(int employeeId);
    boolean save(Employee employee);

}
