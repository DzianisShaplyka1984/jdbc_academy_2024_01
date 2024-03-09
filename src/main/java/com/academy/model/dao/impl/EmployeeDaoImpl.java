package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.EmployeeDao;
import com.academy.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EmployeeDaoImpl extends DefaultDaoImpl<Employee, Integer> implements EmployeeDao {

  public EmployeeDaoImpl() {
    super(Employee.class);
  }

  public List<Employee> getAll() {
    EntityManager entityManager = DataSource.getInstance().getEntityManager();

    Query query = entityManager.createQuery("from Employee");

    return query.getResultList();
  }

  public List<Employee> getAllWithAddress() {
    return null;
  }

  public List<Employee> getByName(String name) {
    return null;
  }

  @Override
  public List<Employee> getBySalary(int salary) {
    return null;
  }
}
