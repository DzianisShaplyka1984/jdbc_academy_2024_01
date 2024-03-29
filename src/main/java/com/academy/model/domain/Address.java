package com.academy.model.domain;

import javax.persistence.Column;
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
  @Column
  private String street;
  @Column
  private String city;
  @Column
  private String appartment;
//  @ManyToOne()
//  @JoinColumn(name = "employee_id")
//  private Employee employee;
}