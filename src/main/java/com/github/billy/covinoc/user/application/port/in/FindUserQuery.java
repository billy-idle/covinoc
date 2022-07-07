package com.github.billy.covinoc.user.application.port.in;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface FindUserQuery {

  @Valid UserResponseModel findByNumberId(@Valid UserFindByIdRequestModel userFindByIdRequestModel);

  List<@Valid UserResponseModel> findAll();
}
