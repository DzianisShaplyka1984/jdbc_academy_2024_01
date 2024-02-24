package com.academy.model.dao.impl;

import com.academy.model.dao.EmployeeDao;
import com.academy.model.domain.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFsDaoImpl implements EmployeeDao {

  @Override
  public void save(Employee employee) {

  }

  @Override
  public void update(Employee employee) {

  }

  @Override
  public void delete(Employee employee) {

  }

  @Override
  public List<Employee> getAll() {
    System.out.println("Read from file");

    List<Employee> employees = new ArrayList<>();
    return employees;
  }

  @Override
  public List<Employee> getAllWithAddress() {
    return null;
  }

  @Override
  public Employee getById(Integer id) {
    return null;
  }

  @Override
  public List<Employee> getByName(String name) {
    return null;
  }

  @Override
  public List<Employee> getBySalary(int salary) {
    return null;
  }
}
