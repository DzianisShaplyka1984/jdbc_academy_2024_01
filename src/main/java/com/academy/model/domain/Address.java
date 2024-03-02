package com.academy.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String street;
  private String city;
  private String appartment;
//  @ManyToOne()
//  @JoinColumn(name = "employee_id")
//  private Employee employee;
}