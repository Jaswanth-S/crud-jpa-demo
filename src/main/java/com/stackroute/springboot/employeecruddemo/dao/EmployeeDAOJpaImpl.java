package com.stackroute.springboot.employeecruddemo.dao;

import com.stackroute.springboot.employeecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager entityManager1)
    {
        entityManager=entityManager1;
    }
    @Override
    public List<Employee> findAll() {

        //create query
        Query query = entityManager.createQuery("from Employee");

        //execute query and get result
        List<Employee> employeeList = query.getResultList();

        //return result
        return employeeList;
    }

    @Override
    public Employee findById(int id) {

        //get employee by id
        Employee employee = entityManager.find(Employee.class,id);

        //return employee
        return employee;
    }

    @Override
    public void save(Employee employee) {
        //save or update
        Employee employee1 = entityManager.merge(employee);

        //update with id from db ... so we generate id for save/update
        employee.setId(employee1.getId());
    }

    @Override
    public void delete(int id) {

        //delete object with primary key
        Query query = entityManager.createQuery("delete from Employee where id = :employeeId");

        query.setParameter("employeeId",id);

        query.executeUpdate();

    }
}
