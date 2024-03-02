package com.academy.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee_department")
public class EmployeeDepartment {
  @Id
  private Integer id;
  private String job;
  @ManyToOne
  @JoinColumn(name = "employee_id")
  private Employee employee;
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
}
