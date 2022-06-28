package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.UseCase;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.UserCreateRequestModel;
import com.github.billy.covinoc.user.application.port.in.CreateUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.out.SaveUser;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
class CreateUserService implements CreateUserUseCase {

  private final SaveUser saveUser;
  private final UserMapper userMapper;

  @Override
  public UserResponseModel create(UserCreateRequestModel userCreateRequestModel) {
    return userMapper.toResponseModel(saveUser.save(userMapper.toDomain(userCreateRequestModel)));
  }
}
