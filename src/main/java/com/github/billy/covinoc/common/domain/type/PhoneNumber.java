package com.github.billy.covinoc.common.domain.type;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.Pattern;

@Value
@EqualsAndHashCode(callSuper = true)
public class PhoneNumber extends BaseType {

  public static final String REGEX = "\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-"
      + ".\\s]?\\d{1,4}[-.\\s]?\\d{1,9}";
  public static final String NOT_VALID = "PhoneNumber.notValid";

  @Pattern(regexp = REGEX, message = NOT_VALID)
  String value;
}
