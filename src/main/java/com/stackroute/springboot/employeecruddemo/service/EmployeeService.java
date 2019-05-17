package com.stackroute.springboot.employeecruddemo.service;

import com.stackroute.springboot.employeecruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
