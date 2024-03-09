package com.academy.model.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class CustomerPK implements Serializable {
  private String email;
  private String brand;
}
