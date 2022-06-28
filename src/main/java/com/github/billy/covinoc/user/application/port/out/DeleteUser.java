package com.github.billy.covinoc.user.application.port.out;

import com.github.billy.covinoc.common.domain.type.NumberId;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface DeleteUser {

  void delete(@Valid NumberId numberId);
}
