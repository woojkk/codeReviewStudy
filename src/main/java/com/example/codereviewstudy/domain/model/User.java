package com.example.codereviewstudy.domain.model;

import java.time.LocalDateTime;

public class User {

  private long id;

  private String loginId;

  private String password;

  private LocalDateTime createdAt;

  private LocalDateTime updatedAt;


  public long getId() {
    return id;
  }


  public String getPassword() {
    return password;
  }

  public String getLoginId() {
    return loginId;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void createUser(Long id, String loginId, String password, LocalDateTime createdAt) {
    this.id = id;
    this.loginId = loginId;
    this.password = password;
    this.createdAt = createdAt;
  }

  public void createUserId(Long userId) {
    this.id = userId;
  }
}
