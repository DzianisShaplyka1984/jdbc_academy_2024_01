package com.academy;

import com.academy.model.dao.EmployeeDao;
import com.academy.model.dao.impl.EmployeeDaoImpl;
import com.academy.model.domain.Address;
import com.academy.model.domain.Employee;
import com.academy.model.domain.EmployeeDepartment;
import java.util.List;

public class Main {

  public static void main(String[] args) {

//    AddressDao addressDao = new AddressDaoImpl();
//
//    List<Address> addresses = addressDao.getAll();

    EmployeeDao employeeDao = new EmployeeDaoImpl();
//
    List<Employee> employees = employeeDao.getAll();

//    Address addressToSave = new Address();
//    addressToSave.setCity("Vitebsk");
//
//    List<Address> addresses = new ArrayList<>();
//    addresses.add(addressToSave);
//
//    Employee employeeToSave = new Employee();
//
//    employeeToSave.setName("Ivan123");
//
//    employeeDao.saveOrUpdate(employeeToSave);

//    Employee employee = new Employee();
//    employee.setId(19);
//
//    employeeDao.delete(employee);

//    Employee employee = employeeDao.getById(10);

//    for (Employee employee :employees) {
//      System.out.println(employee.getName());
//
//      for (Address address : employee.getAddresses()) {
//        System.out.println("   " + "Address: " + address.getCity());
//      }
//
//      for (EmployeeDepartment employeeDepartment : employee.getDepartments()) {
//        System.out.println("   " + "Department: " + employeeDepartment.getDepartment().getName());
//      }
//    }

    //employeeDao.updateCriteria(25, "Hi Mark");
    System.out.println("Hello world");
  }
}
