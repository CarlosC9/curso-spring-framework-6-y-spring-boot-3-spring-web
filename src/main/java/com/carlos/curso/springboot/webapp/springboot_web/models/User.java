package com.carlos.curso.springboot.webapp.springboot_web.models;

public class User {

  private String name;
  private String lastName;

  public User(String name, String lastName) {
    this.name = name;
    this.lastName = lastName;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

}
