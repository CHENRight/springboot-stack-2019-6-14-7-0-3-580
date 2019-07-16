package com.tw.apistackbase.server;

import com.tw.apistackbase.dao.EmployeeDao;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements EmployeeDao {

    public List<Employee> employeeList = new ArrayList<>();

    public EmployeeService(){
        employeeList.add(new Employee(1,"Xiaoming",20,"男"));
        employeeList.add(new Employee(2,"Xiaoming",19,"女"));
        employeeList.add(new Employee(3,"Xiaozhi",15,"男"));
        employeeList.add(new Employee(4,"Xiaogang",16,"男"));
        employeeList.add(new Employee(5,"Xiaoxia",15,"女"));
    }

    @Override
    public Employee findById(int id) {
        List<Employee> employees =  employeeList.stream().filter(employee -> id == employee.getId()).collect(Collectors.toList());
        return employees.size() > 0 ? employees.get(0) : null;
    }
    

    @Override
    public List<Employee> findAll() {
        return employeeList;
    }

    public List<Employee> findAll(int age) {
        return employeeList.stream().filter(employee -> employee.getAge() > age).collect(Collectors.toList());
    }

    public boolean save(Employee employee) {
        if(employeeList.contains(employee)){
            return false;
        }else {
            return true;
        }
    }


    @Override
    public boolean delete(int employeeId){
        List<Employee> employees =  employeeList.stream().filter(employee1 -> employeeId == employee1.getId()).collect(Collectors.toList());
        if(employees.size() > 0){
            employeeList.remove(employeeList.stream().filter(employee1 -> employeeId == employee1.getId()).collect(Collectors.toList()).get(0));
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Employee employee){
        List<Employee> employees =  employeeList.stream().filter(employee1 -> employee.equals(employee1)).collect(Collectors.toList());
        if(employees.size() > 0){
            employees.get(0).update(employee);
            return true;
        }
        return false;
    }
}
