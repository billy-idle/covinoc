package com.github.billy.covinoc.service;

import com.github.billy.covinoc.domain.User;

import java.util.List;

public interface UserService {

  User createUser(String name, String numberId, String phoneNumber);

  User updateUser(Integer id, String name, String numberId, String phoneNumber);

  List<User> getUsers();

  void deleteUser(Integer id);
}
