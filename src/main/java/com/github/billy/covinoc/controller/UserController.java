package com.github.billy.covinoc.controller;

import com.github.billy.covinoc.domain.User;
import com.github.billy.covinoc.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

  private UserService userService;

  @PostMapping("/create")
  public User createUser(String name, String numberId, String phoneNumber) {
    return userService.createUser(name, numberId, phoneNumber);
  }

  @PutMapping("/update")
  public User updateUser(Integer id, String name, String numberId, String phoneNumber) {
    return userService.updateUser(id, name, numberId, phoneNumber);
  }

  @GetMapping("/get")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  @DeleteMapping("/delete")
  public String deleteUser(Integer id) {
    userService.deleteUser(id);
    return "User deleted";
  }
}
