package com.github.billy.covinoc.user.adapter.out.persistence;

import com.github.billy.covinoc.common.annotation.PersistenceAdapter;
import com.github.billy.covinoc.common.domain.type.NumberId;
import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.out.DeleteUser;
import com.github.billy.covinoc.user.application.port.out.FindUser;
import com.github.billy.covinoc.user.application.port.out.SaveUser;
import com.github.billy.covinoc.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.List;

@PersistenceAdapter
@RequiredArgsConstructor
class UserPersistenceAdapter implements SaveUser, DeleteUser, FindUser {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public User save(User user) {
    return userMapper.toDomain(userRepository.save(userMapper.toJpaEntity(user)));
  }

  @Override
  public void delete(NumberId numberId) {
    userRepository.deleteByNumberId(numberId.getValue());
  }

  @Override
  public User findByNumberId(NumberId numberId) {
    return userMapper.toDomain(userRepository.findByNumberId(numberId.getValue()));
  }

  @Override
  public List<User> findAll() {
    return userMapper.toDomain(userRepository.findAll());
  }
}
