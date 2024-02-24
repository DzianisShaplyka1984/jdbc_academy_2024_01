package com.academy;

import com.academy.model.dao.EmployeeDao;
import com.academy.model.dao.impl.EmployeeDaoImpl;
import com.academy.model.dao.impl.EmployeeFsDaoImpl;
import com.academy.model.domain.Employee;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    EmployeeDao employeeDao = new EmployeeDaoImpl();

    List<Employee> employees = employeeDao.getAll();

    System.out.println("Hello world");
  }
}
