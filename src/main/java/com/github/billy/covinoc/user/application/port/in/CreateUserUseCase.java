package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface CreateUserUseCase {

  @Valid UserResponseModel create(@Valid UserCreateRequestModel userCreateRequestModel);
}
