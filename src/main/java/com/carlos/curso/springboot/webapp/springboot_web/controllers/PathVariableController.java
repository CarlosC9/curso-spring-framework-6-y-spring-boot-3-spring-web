package com.carlos.curso.springboot.webapp.springboot_web.controllers;

import com.carlos.curso.springboot.webapp.springboot_web.models.User;
import com.carlos.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

  @Value("${config.username}")
  private String username;

  @Value("${config.listOfValues}")
  private List<String> listOfValues;

  @Value("${config.code}")
  private Integer code;

  @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")
  private List<String> valueList;

  @Value("#{'${config.listOfValues}'}")
  private String valueString;

  @Value("#{${config.valuesMap}}")
  private Map<String, Object> valuesMap;

  @Value("#{${config.valuesMap}.product}")
  private String product;

  @Value("#{${config.valuesMap}.price}")
  private Long price;

  @GetMapping("/baz/{message}")
  public ParamDto baz(
    @PathVariable String message
  ) {
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

  @GetMapping("/mix/{product}/{id}")
  public Map<String, Object> mixPathVar(
    @PathVariable String product,
    @PathVariable Long id
  ) {
    Map<String, Object> json = new HashMap<>();

    json.put("product", product);
    json.put("id", id);

    return json;
  }

  @PostMapping("/create")
  public User create(@RequestBody User user) {
    // hacer algo en la bbdd
    user.setName(user.getName().toUpperCase());
    return user;
  }

  @GetMapping("/values")
  public Map<String, Object> values(@Value("${config.message}") String message) {
    Map<String, Object> json = new HashMap<>();
    json.put("username", this.username);
    json.put("message", message);
    json.put("listOfValues", this.listOfValues);
    json.put("code", this.code);
    json.put("valueList", this.valueList);
    json.put("valueString", this.valueString);
    json.put("valuesMap", this.valuesMap);
    json.put("product", this.product);
    json.put("price", this.price);
    return json;
  }

}
