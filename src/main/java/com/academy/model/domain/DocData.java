package com.academy.model.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class DocData {
  @Column(name = "doc_number")
  private String docNumber;
  @Column(name = "doc_type")
  private String docType;
  @Column(name = "doc_issue_date")
  private String docIssueDate;
}
