package com.github.billy.covinoc.user.adapter.in.web;

import com.github.billy.covinoc.common.annotation.WebAdapter;
import com.github.billy.covinoc.user.application.port.in.CreateUserUseCase;
import com.github.billy.covinoc.user.application.port.in.DeleteUserUseCase;
import com.github.billy.covinoc.user.application.port.in.FindUserQuery;
import com.github.billy.covinoc.user.application.port.in.UpdateUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserCreateRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserDeleteRequestModel;
import com.github.billy.covinoc.user.application.port.in.UserResponseModel;
import com.github.billy.covinoc.user.application.port.in.UserUpdateRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@WebAdapter
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final CreateUserUseCase createUserUseCase;
  private final UpdateUserUseCase updateUserUseCase;
  private final DeleteUserUseCase deleteUserUseCase;
  private final FindUserQuery findUserQuery;

  @PostMapping("/create")
  @ResponseStatus(value = HttpStatus.CREATED)
  public UserResponseModel createUser(@RequestBody UserCreateRequestModel userCreateRequestModel) {
    return createUserUseCase.create(userCreateRequestModel);
  }

  @PutMapping("/update")
  public UserResponseModel updateUser(@RequestBody UserUpdateRequestModel userUpdateRequestModel) {
    return updateUserUseCase.update(userUpdateRequestModel);
  }

  @DeleteMapping("/delete")
  public void deleteUser(@RequestBody UserDeleteRequestModel userDeleteRequestModel) {
    deleteUserUseCase.delete(userDeleteRequestModel);
  }

  @GetMapping("/find-by-number-id") // https://stackoverflow.com/questions/42256358/spring-getmapping-with-requestparam-and-requestbody-fails-with-httpmessagenot
  public UserResponseModel findUserByNumberId(@RequestParam String value) {
    return findUserQuery.findByNumberId(value);
  }

  @GetMapping("/find-all")
  public List<UserResponseModel> findAllUsers() {
    return findUserQuery.findAll();
  }
}
