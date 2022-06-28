package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface UpdateUserUseCase {

  @Valid UserResponseModel update(@Valid UserUpdateRequestModel userUpdateRequestModel);
}
