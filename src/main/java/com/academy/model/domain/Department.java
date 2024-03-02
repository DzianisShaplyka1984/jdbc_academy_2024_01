package com.academy.model.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Department {
  @Id
  private Integer id;
  private String name;
}