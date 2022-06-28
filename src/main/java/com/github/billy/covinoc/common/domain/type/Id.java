package com.github.billy.covinoc.common.domain.type;

import lombok.EqualsAndHashCode;
import lombok.Value;

import javax.validation.constraints.PositiveOrZero;

@Value
@EqualsAndHashCode(callSuper = true)
public class Id extends BaseType {

  public static final String POSITIVE = "Id.Positive";
  public static final String POSITIVE_OR_ZERO = "Id.PositiveOrZero";

  @PositiveOrZero(message = POSITIVE_OR_ZERO)
  Integer value;
}
