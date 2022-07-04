package com.github.billy.covinoc.user.adapter.in.web;

import com.github.billy.covinoc.user.application.mapper.UserMapper;
import com.github.billy.covinoc.user.application.port.in.CreateUserUseCase;
import com.github.billy.covinoc.user.application.port.in.UserCreateRequestModel;
import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

  private final String url = "http://localhost:";
  private final Faker faker = new Faker();
  @LocalServerPort
  private int port;
  @Autowired
  private TestRestTemplate restTemplate;
  @Autowired
  private CreateUserUseCase createUserUseCase;
  @Autowired
  private UserMapper userMapper;

  @Test
  void createUser() throws JSONException {
    assertTrue(restTemplate.exchange(url + port + "/user/create", HttpMethod.POST,
                               getStringHttpEntity(userMapper.toJson(generateFakeUser())),
                               String.class)
                           .getStatusCode()
                           .is2xxSuccessful());
  }

  private HttpEntity<String> getStringHttpEntity(JSONObject userJson) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    return new HttpEntity<>(userJson.toString(), headers);
  }

  private UserCreateRequestModel generateFakeUser() {
    return UserCreateRequestModel.builder()
                                 .name(faker.name().fullName())
                                 .numberId(String.valueOf(
                                     faker.number().numberBetween(14396943, 99999999)))
                                 .phoneNumber("3005707035")
                                 .build();
  }

  @Test
  void updateUser() {
    UserCreateRequestModel userCreateRequestModel = generateFakeUser();

//    UserResponseModel userResponseModel = createUserUseCase.create(userCreateRequestModel);
//
//    UserResponseModel.builder().
//    userResponseModel.setName(faker.name().fullName());
//
//    assertTrue(restTemplate.exchange(url + port + "/user/update", HttpMethod.PUT,
//        getStringHttpEntity(userToJSON(userResponseModel)), String.class).getStatusCode()
//        .is2xxSuccessful());
  }

  @Test
  void deleteUser() {
  }

  @Test
  void findByNumberId() {
  }

  @Test
  void findAll() {
  }
}