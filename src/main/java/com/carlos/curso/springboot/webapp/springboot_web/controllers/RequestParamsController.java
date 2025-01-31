package com.carlos.curso.springboot.webapp.springboot_web.controllers;

import com.carlos.curso.springboot.webapp.springboot_web.models.dto.ParamDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamsController {

  @GetMapping("/foo")
  public ParamDto foo(
    @RequestParam(required = false, defaultValue = "Hola que tal") String message
  ) {
    ParamDto param = new ParamDto();
    param.setMessage(message);

    return param;
  }

}
