package com.github.billy.covinoc.common.domain.type;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
@EqualsAndHashCode(callSuper = true)
public class NumberId extends BaseType {

  public static final String REGEX = "\\d{5,20}";
  public static final String NOT_VALID = "NumberId.notValid";

  @Pattern(regexp = REGEX, message = NOT_VALID)
  String value;
}
