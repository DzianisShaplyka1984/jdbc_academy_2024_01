package com.academy;

import com.academy.model.dao.EmployeeDao;
import com.academy.model.dao.impl.EmployeeDaoImpl;
import com.academy.model.domain.Employee;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    EmployeeDao employeeDao = new EmployeeDaoImpl();
//
//    List<Employee> employees = employeeDao.getAll();
//
//    Employee employee = new Employee();
//
//    employee.setId(50);
//    employee.setName("Dzianis");
//    employee.setJob("Manager");
//
//    employeeDao.saveOrUpdate(employee);

//    Employee employee = new Employee();
//    employee.setId(19);
//
//    employeeDao.delete(employee);

    Employee employee = employeeDao.getById(10);
    System.out.println("Hello world");
  }
}
