package com.academy.model.domain;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer {
  @EmbeddedId
  private CustomerPK id;
  private String name;
}
