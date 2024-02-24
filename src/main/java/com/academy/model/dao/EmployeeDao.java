package com.academy.model.dao;

import com.academy.model.domain.Employee;
import java.util.List;

public interface EmployeeDao extends DefaultDao<Employee, Integer>{
  List<Employee> getAllWithAddress();

  List<Employee> getByName(String name);

  List<Employee> getBySalary(int salary);
}
