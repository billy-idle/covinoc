package com.github.billy.covinoc.common.adapter.out.persistence;

import com.github.billy.covinoc.common.utilities.Utility;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Optional;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseJpaEntity extends AuditableEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Transient
  private boolean isNew = true;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String status;

  public boolean isNew() {
    return Optional.ofNullable(id).orElse(Utility.INTEGER_ZERO).equals(Utility.INTEGER_ZERO);
  }

  @PrePersist
  @PostLoad
  void markNotNew() {
    this.isNew = false;
  }
}