package com.stackroute.springboot.employeecruddemo.dao;


import com.stackroute.springboot.employeecruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    //constructor injection of entity manager
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager)
    {
        entityManager  =  theEntityManager;
    }

    @Override
    public List<Employee> findAll()
    {
        //get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create query
        Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);

        //execute query and result
        List<Employee> employeeList = query.getResultList();

        //return the results
        return employeeList;
    }

    @Override
    public Employee findById(int id) {

        //get hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //get the employee
        Employee employee = currentSession.get(Employee.class,id);

        //return employee
        return employee;
    }

    @Override
    public void save(Employee employeeId) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employeeId);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query query = currentSession.createQuery(
                "delete from Employee where id=:employeeId");
       query.setParameter("employeeId",id);
       query.executeUpdate();
    }
}
