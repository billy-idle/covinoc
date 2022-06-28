package com.github.billy.covinoc.common.domain.type.status.validator;

import com.github.billy.covinoc.common.domain.type.status.Status;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class StatusSubSetValidator implements ConstraintValidator<StatusSubset, Status> {

  private Status[] subset;

  @Override
  public void initialize(StatusSubset constraint) {
    this.subset = constraint.anyOf();
  }

  @Override
  public boolean isValid(Status value, ConstraintValidatorContext context) {
    return value == null || Arrays.asList(subset).contains(value);
  }
}