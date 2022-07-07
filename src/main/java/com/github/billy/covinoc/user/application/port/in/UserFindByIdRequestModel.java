package com.github.billy.covinoc.user.application.port.in;

import com.github.billy.covinoc.common.domain.type.NumberId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserFindByIdRequestModel {

  @Pattern(regexp = NumberId.REGEX, message = NumberId.NOT_VALID)
  String numberId;
}
