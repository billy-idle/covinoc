package com.github.billy.covinoc.user.adapter.out.persistence;

import com.github.billy.covinoc.common.adapter.out.persistence.BaseJpaEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "users") // https://github.com/h2database/h2database/issues/3363
public class UserJpaEntity extends BaseJpaEntity {
  @Column(nullable = false)
  private String name;
  @Column(nullable = false, unique = true)
  private String numberId;
  @Column(nullable = false)
  private String phoneNumber;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserJpaEntity)) {
      return false;
    }
    UserJpaEntity that = (UserJpaEntity) o;
    return numberId.equals(that.numberId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberId);
  }
}
