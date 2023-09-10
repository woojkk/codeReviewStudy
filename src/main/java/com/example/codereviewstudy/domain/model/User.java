package com.example.codereviewstudy.domain.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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

  public void setId(long userId) {
    this.id = userId;
  }


  public void setPassword(String password) {
    this.password = password;
  }

  public void setLoginId(String email) {
    this.loginId = email;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}
