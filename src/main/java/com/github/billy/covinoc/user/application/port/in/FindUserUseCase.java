package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface FindUserUseCase {

  @Valid UserResponseModel findByNumberId(@Valid UserFindRequestModel userFindRequestModel);

  List<@Valid UserResponseModel> findAll();
}
