package com.example.codereviewstudy.domain.dto;

import com.example.codereviewstudy.domain.model.User;

public class UserDto {
  private Long userId;
  private String loginId;

  public Long getUserId() {
    return userId;
  }

  public String getLoginId() {
    return loginId;
  }


  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setLoginId(String loginId) {
    this.loginId = loginId;
  }

  public static UserDto from(User user) {
    UserDto userDto = new UserDto();
    userDto.setUserId(user.getId());
    userDto.setLoginId(user.getLoginId());
    return userDto;
  }
}
