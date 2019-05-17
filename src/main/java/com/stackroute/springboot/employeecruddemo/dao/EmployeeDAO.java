package com.stackroute.springboot.employeecruddemo.dao;

import com.stackroute.springboot.employeecruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void save(Employee employee);

    public void delete(int id);
}
