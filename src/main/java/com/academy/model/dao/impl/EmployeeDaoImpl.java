package com.academy.model.dao.impl;

import com.academy.model.DataSource;
import com.academy.model.dao.EmployeeDao;
import com.academy.model.domain.Address;
import com.academy.model.domain.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

  public void save(Employee employee) {
    Connection connection = DataSource.getInstance().getConnection();

    try (PreparedStatement statement = connection.prepareStatement("insert into employee (name, job, salary) values (?, ?, ?)")) {
      statement.setString(1, employee.getName());
      statement.setString(2, employee.getJob());
      statement.setInt(3, employee.getSalary());

      statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void update(Employee employee) {

  }

  public void delete(Employee employee) {

  }

  public List<Employee> getAll() {
    Connection connection = DataSource.getInstance().getConnection();

    List<Employee> employees = new ArrayList<>();

    try (PreparedStatement statement = connection.prepareStatement("select * from employee")) {
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        Employee employee = new Employee();
        employee.setId(result.getInt("id"));
        employee.setName(result.getString("name"));
        employee.setJob(result.getString("job"));
        employee.setYear(result.getInt("year"));
        employee.setSalary(result.getInt("salary"));
        employee.setEmail(result.getString("email"));
        employee.setAccount(result.getInt("account"));

        employees.add(employee);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employees;
  }

  public List<Employee> getAllWithAddress() {
    Connection connection = DataSource.getInstance().getConnection();

    List<Employee> employees = new ArrayList<>();

    try (PreparedStatement statement = connection.prepareStatement("select employee.id as employeeId, name, job, year, email, account, salary, address.id as addressId, street, city, appartment from employee left join address on employee.id = address.employee_id")) {
      ResultSet result = statement.executeQuery();

      while (result.next()) {
        Employee employee = new Employee();
        employee.setId(result.getInt("employeeId"));
        employee.setName(result.getString("name"));
        employee.setJob(result.getString("job"));
        employee.setYear(result.getInt("year"));
        employee.setSalary(result.getInt("salary"));
        employee.setEmail(result.getString("email"));
        employee.setAccount(result.getInt("account"));

        List<Address> addresses = new ArrayList<>();
        if (result.getString("city") != null) {
          Address address = new Address();

          address.setId(result.getInt("addressId"));
          address.setCity(result.getString("city"));
          address.setStreet(result.getString("street"));
          address.setAppartment(result.getString("appartment"));

          addresses.add(address);
        }

        employee.setAddresses(addresses);
        employees.add(employee);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employees;
  }

  public Employee getById(Integer id) {
    Connection connection = DataSource.getInstance().getConnection();

    Employee employee = null;

    try (PreparedStatement statement = connection.prepareStatement("select * from employee where id=?")) {
      statement.setInt(1, id);

      ResultSet result = statement.executeQuery();

      while (result.next()) {
        employee = new Employee();

        employee.setId(result.getInt("id"));
        employee.setName(result.getString("name"));
        employee.setJob(result.getString("job"));
        employee.setYear(result.getInt("year"));
        employee.setSalary(result.getInt("salary"));
        employee.setEmail(result.getString("email"));
        employee.setAccount(result.getInt("account"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return employee;
  }

  public List<Employee> getByName(String name) {
    return null;
  }

  @Override
  public List<Employee> getBySalary(int salary) {
    return null;
  }
}
