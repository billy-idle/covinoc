package com.github.billy.covinoc.common.utilities.error;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class ErrorResponse {

  private final List<java.lang.Error> errors = new ArrayList<>();
}
