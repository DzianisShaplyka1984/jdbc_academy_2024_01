package com.academy.model.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.SelectBeforeUpdate;

@Data
@Entity
@Table(name = "employee")
//@Immutable
public class Employee extends ModifierOptions{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private Integer year;
  private String email;
  private Integer salary;
  private Integer account;
  @Column(name = "phone")
  private String employeePhone;
  @Formula(value = "Concat(name, year)")
  private String nameYear;
  @Embedded
  private DocData docData;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = "employee_id")
  private List<Address> addresses;
//  @OneToMany(mappedBy = "employee")
//  private List<EmployeeDepartment> departments;
}
