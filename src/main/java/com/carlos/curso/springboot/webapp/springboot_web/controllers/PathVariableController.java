package com.carlos.curso.springboot.webapp.springboot_web.controllers;

import com.carlos.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

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
}
