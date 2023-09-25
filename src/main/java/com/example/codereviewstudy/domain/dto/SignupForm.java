package com.example.codereviewstudy.domain.dto;

public class SignupForm {
  private String loginId;
  private String password;

  public String getLoginId() {
    return loginId;
  }

  public String getPassword() {
    return password;
  }

  public SignupForm(String loginId, String password) {
    this.loginId = loginId;
    this.password = password;
  }
}
