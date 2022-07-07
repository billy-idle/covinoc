package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.QueryService;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.FindUserQuery;
import com.github.billy.covinoc.user.application.port.in.UserFindByIdRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.out.FindUser;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
class FindUserService implements FindUserQuery {

  private final FindUser findUser;
  private final UserMapper userMapper;

  @Override
  public UserResponseModel findByNumberId(UserFindByIdRequestModel userFindByIdRequestModel) {
    return userMapper.toResponseModel(
        findUser.findByNumberId(userMapper.toNumberId(userFindByIdRequestModel)));
  }

  @Override
  public List<UserResponseModel> findAll() {
    return userMapper.toResponseModel(findUser.findAll());
  }
}
