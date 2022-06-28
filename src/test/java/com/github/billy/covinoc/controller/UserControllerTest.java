package com.github.billy.covinoc.controller;

import com.github.billy.covinoc.domain.User;
import com.github.billy.covinoc.service.UserService;
import com.github.javafaker.Faker;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
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
  private UserService userService;

  @Test
  void createUser() throws JSONException {
    assertTrue(restTemplate.exchange(url + port + "/user/create", HttpMethod.POST,
                               getStringHttpEntity(userToJSON(generateFakeUser())), String.class)
                           .getStatusCode().is2xxSuccessful());
  }

  private HttpEntity<String> getStringHttpEntity(JSONObject userJson) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    return new HttpEntity<>(userJson.toString(), headers);
  }

  private JSONObject userToJSON(User user) throws JSONException {

    JSONObject userJson = new JSONObject();

    if (user.getId() != null) {
      userJson.put("id", user.getId());
    }

    userJson.put("name", user.getName());
    userJson.put("numberId", user.getNumberId());
    userJson.put("phoneNumber", user.getPhoneNumber());

    return userJson;
  }

  private User generateFakeUser() {
    return User.builder().id(faker.number().randomDigit()).name(faker.name().fullName())
               .numberId(String.valueOf(faker.number().randomNumber()))
               .phoneNumber(faker.phoneNumber().phoneNumber()).build();
  }

  @Test
  void updateUser() throws JSONException {
    User user = userService.createUser(faker.name().fullName(),
        String.valueOf(faker.number().randomNumber()), faker.phoneNumber().phoneNumber());

    user.setName(faker.name().fullName());

    assertTrue(restTemplate.exchange(url + port + "/user/update", HttpMethod.PUT,
        getStringHttpEntity(userToJSON(user)), String.class).getStatusCode().is2xxSuccessful());
  }

  @Test
  void getUsers() {
    for (int i = 0; i < 10; i++) {
      userService.createUser(faker.name().fullName(), String.valueOf(faker.number().randomNumber()),
          faker.phoneNumber().phoneNumber());
    }

    assertTrue(restTemplate.exchange(url + port + "/user/get", HttpMethod.GET, null,
        String.class).getStatusCode().is2xxSuccessful());
  }

  @Test
  void deleteUser() {
    User user = userService.createUser(faker.name().fullName(),
        String.valueOf(faker.number().randomNumber()), faker.phoneNumber().phoneNumber());

    assertTrue(restTemplate
        .exchange(url + port + "/user/delete" + "?id=" + user.getId(), HttpMethod.DELETE,
            null, String.class).getStatusCode().is2xxSuccessful());
  }
}