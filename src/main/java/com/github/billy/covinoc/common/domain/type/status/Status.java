package com.github.billy.covinoc.common.domain.type.status;

import com.github.billy.covinoc.common.utilities.Utility;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Status {
  ACTIVE("ACTIVE"),
  INACTIVE("INACTIVE");

  public static final String USER_STATUS_REGEX = "ACTIVE|INACTIVE";
  public static final String USER_STATUS_NOT_VALID = "User.statusNotValid";

  private final String value;
  public static Status of(String value) {
    if (Optional.ofNullable(value).isPresent()) {
      for (Status status : Status.values()) {
        if (value.equals(status.getValue())) {
          return status;
        }
      }
    } else {
      Utility.throwConflictException("Status.enumValueIsNull");
    }

    throw Utility.getConflictException("Status.typeDoesNotExist");
  }
}