package com.academy.model.domain;

import java.util.List;
import lombok.Data;

@Data
public class Employee {
  private Integer id;
  private String name;
  private String job;
  private Integer year;
  private String email;
  private Integer salary;
  private Integer account;
  private List<Address> addresses;
}
