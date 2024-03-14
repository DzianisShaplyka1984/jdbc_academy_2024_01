package com.academy.model.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class ModifierOptions {
  @Column(name = "created_at")
  private String createdAt;
  @Column(name = "created_by")
  private String createdBy;
  @Column(name = "updated_at")
  private String updatedAt;
  @Column(name = "updated_by")
  private String updatedBy;
}
