package com.carlos.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carlos.curso.springboot.webapp.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.curso.springboot.webapp.springboot_web.models.User;

@RestController
@RequestMapping("/api")
public class UserRestController {

  @GetMapping("/details")
  public UserDto details() {
    User user = new User("Carlos", "Caraballo");
    UserDto userDto = new UserDto();
    userDto.setUser(user);
    userDto.setTitle("Hola Mundo Spring Boot");
    return userDto;
  }

  @GetMapping("/list")
  public List<User> list() {
    List<User> users = new ArrayList<>();
    users.add(new User("Carlos", "Caraballo"));
    users.add(new User("Xiomara", "Jimenez"));
    users.add(new User("Pepe", "Santana"));

    return users;
  }

  @GetMapping("/details-map")
  public Map<String, Object> detailsMap() {
    User user = new User("Carlos", "Caraballo");
    Map<String, Object> body = new HashMap<>();

    body.put("title", "Hola Mundo Spring Boot");
    body.put("user", user);
    return body;
  }

}
