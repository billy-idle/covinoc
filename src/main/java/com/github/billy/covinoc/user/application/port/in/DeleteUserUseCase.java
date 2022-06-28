package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface DeleteUserUseCase {

  void delete(@Valid UserDeleteRequestModel updateUserRequestModel);
}
