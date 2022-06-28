package com.github.billy.covinoc.user.application.port.in;

import com.github.billy.covinoc.common.domain.type.Id;
import com.github.billy.covinoc.common.domain.type.Name;
import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.common.domain.type.PhoneNumber;
import com.github.billy.covinoc.common.domain.type.status.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import net.andreinc.jbvext.annotations.str.AlphaSpace;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserUpdateRequestModel {

  @Positive(message = Id.POSITIVE)
  int id;
  @AlphaSpace(message = Name.NOT_VALID)
  String name;
  @Pattern(regexp = NumberId.REGEX, message = NumberId.NOT_VALID)
  String numberId;
  @Pattern(regexp = PhoneNumber.REGEX, message = PhoneNumber.NOT_VALID)
  String phoneNumber;
  @Pattern(regexp = Status.USER_STATUS_REGEX, message = Status.USER_STATUS_NOT_VALID)
  String status;
}
