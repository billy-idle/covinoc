package com.github.billy.covinoc.user.domain;

import com.github.billy.covinoc.common.domain.BaseDomain;
import com.github.billy.covinoc.common.domain.type.Id;
import com.github.billy.covinoc.common.domain.type.Name;
import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.common.domain.type.PhoneNumber;
import com.github.billy.covinoc.common.domain.type.status.Status;
import com.github.billy.covinoc.common.domain.type.status.validator.StatusSubset;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.validation.Valid;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class User extends BaseDomain {

  @Valid
  private final Name name;
  @Valid
  @EqualsAndHashCode.Include
  private final NumberId numberId;
  @Valid
  private final PhoneNumber phoneNumber;

  @StatusSubset(anyOf = {Status.ACTIVE, Status.INACTIVE}, message = Status.USER_STATUS_NOT_VALID)
  Status status;

  @Builder
  public User(@Valid Id id, Name name, NumberId numberId, PhoneNumber phoneNumber, Status status) {
    super(id);
    this.name = name;
    this.numberId = numberId;
    this.phoneNumber = phoneNumber;
    this.status = status;
  }
}
