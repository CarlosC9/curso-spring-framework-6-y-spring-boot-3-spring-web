package com.carlos.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.carlos.curso.springboot.webapp.springboot_web.models.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

  @GetMapping("/details")
  public String details(Model model) {
    User user = new User("Carlos", "Caraballo");
    model.addAttribute("title", "Hola Mundo Spring Boot");
    model.addAttribute("user", user);
    return "details";
  }

  @GetMapping("list")
  public String list(ModelMap model) {
    List<User> users = new ArrayList<>();

    model.addAttribute("users", users);
    model.addAttribute("title", "Lista de usuarios");

    users.add(new User("Carlos", "Caraballo"));
    users.add(new User("Xiomara", "Jimenez", "xomi@example.com"));
    users.add(new User("Pepe", "Santana", "pepe@example.com"));

    return "list";
  }

}
