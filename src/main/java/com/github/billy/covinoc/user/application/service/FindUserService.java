package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.QueryService;
import com.github.billy.covinoc.common.mapper.NumberIdMapper;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.FindUserQuery;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.out.FindUser;
import lombok.RequiredArgsConstructor;

import java.util.List;

@QueryService
@RequiredArgsConstructor
class FindUserService implements FindUserQuery {

  private final FindUser findUser;
  private final UserMapper userMapper;
  private final NumberIdMapper numberIdMapper;

  @Override
  public UserResponseModel findByNumberId(String value) {
    return userMapper.toResponseModel(
        findUser.findByNumberId(numberIdMapper.map(value)));
  }

  @Override
  public List<UserResponseModel> findAll() {
    return userMapper.toResponseModel(findUser.findAll());
  }
}
