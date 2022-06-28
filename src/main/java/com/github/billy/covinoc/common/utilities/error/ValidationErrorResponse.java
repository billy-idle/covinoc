package com.github.billy.covinoc.common.utilities.error;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class ValidationErrorResponse {

  private final List<Violation> violations = new ArrayList<>();
}
