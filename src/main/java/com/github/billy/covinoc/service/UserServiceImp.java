package com.github.billy.covinoc.service;

import com.github.billy.covinoc.domain.User;
import com.github.billy.covinoc.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;

  @Override
  public User createUser(String name, String numberId, String phoneNumber) {
    return userRepository.save(
        User.builder().name(name).numberId(numberId).phoneNumber(phoneNumber).build());
  }

  @Override
  public User updateUser(Integer id, String name, String numberId, String phoneNumber) {
    return userRepository.save(
        User.builder().id(id).name(name).numberId(numberId).phoneNumber(phoneNumber).build());
  }

  @Override
  public List<User> getUsers() {
    return userRepository.findAll();
  }

  @Override
  public void deleteUser(Integer id) {
    userRepository.deleteById(id);
  }
}
