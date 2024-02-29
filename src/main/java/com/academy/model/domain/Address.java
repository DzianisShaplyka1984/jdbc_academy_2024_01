package com.academy.model.domain;

import lombok.Data;

@Data
public class Address {
  private Integer id;
  private String street;
  private String city;
  private String appartment;
  private Employee employee;
}