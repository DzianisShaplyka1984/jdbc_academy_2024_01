package com.academy.model.dao;

import com.academy.model.domain.Address;
import com.academy.model.domain.Employee;
import java.util.List;

public interface EmployeeDao extends DefaultDao<Employee, Integer>{
  List<Employee> getAllWithAddress();

  List<Employee> getByName(String name);

  List<Employee> getBySalary(int salary);

  List<String> getNames();
  List<Integer> getSalary();
  List<Address> getAddress();

  Employee findById(Integer id);

  List<Object> getCountNames();

  void updateSalary(Integer id, Integer salary);

  void deleteEmployee(Integer id);

  void insertEmployee(Integer id);

  List<Integer> getMaxSalary();

  List<Employee> findSorted(boolean sort, String orderBy);

  List<Employee> getAllCriteria();
}
