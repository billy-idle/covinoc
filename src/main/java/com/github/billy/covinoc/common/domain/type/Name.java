package com.github.billy.covinoc.common.domain.type;

import lombok.EqualsAndHashCode;
import lombok.Value;
import net.andreinc.jbvext.annotations.str.AlphanumericSpace;

@Value
@EqualsAndHashCode(callSuper = true)
public class Name extends BaseType {

  public static final String NOT_VALID = "Name.notValid";

  @AlphanumericSpace(message = NOT_VALID)
  String value;
}
