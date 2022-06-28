package com.github.billy.covinoc.user.application.port.in;

import com.github.billy.covinoc.common.domain.type.Name;
import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.common.domain.type.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import net.andreinc.jbvext.annotations.str.AlphaSpace;

import javax.validation.constraints.Pattern;

@Value
@Builder(toBuilder = true)
@AllArgsConstructor
public class UserCreateRequestModel {

  @AlphaSpace(message = Name.NOT_VALID)
  String name;
  @Pattern(regexp = NumberId.REGEX, message = NumberId.NOT_VALID)
  String numberId;
  @Pattern(regexp = PhoneNumber.REGEX, message = PhoneNumber.NOT_VALID)
  String phoneNumber;
}
