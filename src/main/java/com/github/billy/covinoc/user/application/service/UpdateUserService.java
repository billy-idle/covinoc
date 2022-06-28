package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.UseCase;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.UserUpdateRequestModel;
import com.github.billy.covinoc.user.application.port.in.UpdateUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.out.SaveUser;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class UpdateUserService implements UpdateUserUseCase {

  private final SaveUser saveUser;
  private final UserMapper userMapper;

  @Override
  public UserResponseModel update(UserUpdateRequestModel userUpdateRequestModel) {
    return userMapper.toResponseModel(saveUser.save(userMapper.toDomain(userUpdateRequestModel)));
  }
}
