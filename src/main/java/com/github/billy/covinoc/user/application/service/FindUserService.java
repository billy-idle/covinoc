package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.UseCase;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.FindUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserFindRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.out.FindUser;
import lombok.RequiredArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@UseCase
@RequiredArgsConstructor
class FindUserService implements FindUserUseCase {

  private final FindUser findUser;
  private final UserMapper userMapper;

  @Override
  public UserResponseModel findByNumberId(UserFindRequestModel userFindRequestModel) {
    return userMapper.toResponseModel(
        findUser.findByNumberId(userMapper.toNumberId(userFindRequestModel)));
  }

  @Override
  public List<@Valid UserResponseModel> findAll() {
    return userMapper.toResponseModel(findUser.findAll());
  }
}
