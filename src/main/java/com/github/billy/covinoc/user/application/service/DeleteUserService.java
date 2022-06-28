package com.github.billy.covinoc.user.application.service;

import com.github.billy.covinoc.common.annotation.UseCase;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.DeleteUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserDeleteRequestModel;
import com.github.billy.covinoc.user.application.port.out.DeleteUser;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class DeleteUserService implements DeleteUserUseCase {

  private final DeleteUser deleteUser;
  private final UserMapper userMapper;

  @Override
  public void delete(UserDeleteRequestModel updateUserRequestModel) {
    deleteUser.delete(userMapper.toNumberId(updateUserRequestModel));
  }
}

