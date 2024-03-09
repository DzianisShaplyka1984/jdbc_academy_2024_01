package com.academy.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Login {
  @Id
  private Integer id;
  private String login;
  private String password;
//  @OneToOne
//  @JoinColumn(name = "employee_id")
//  private Employee employee;
}
