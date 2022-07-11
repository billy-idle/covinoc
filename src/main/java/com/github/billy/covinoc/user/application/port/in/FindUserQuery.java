package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

import static com.github.billy.covinoc.common.domain.type.NumberId.NOT_VALID;
import static com.github.billy.covinoc.common.domain.type.NumberId.REGEX;

@Validated
public interface FindUserQuery {

  @Valid UserResponseModel findByNumberId(
      @Pattern(regexp = REGEX, message = NOT_VALID) String value);

  List<@Valid UserResponseModel> findAll();
}
