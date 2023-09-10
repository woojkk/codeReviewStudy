package com.example.codereviewstudy.exception;

import org.springframework.http.HttpStatus;

public enum UserErrorCode {
  ALREADY_EXIST_LOGINID(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디입니다."),
  NOT_FOUND_LOGINID(HttpStatus.BAD_REQUEST, "해당 ID가 존재하지 않습니다.");

  private final HttpStatus httpStatus;
  private final String detail;

  UserErrorCode(HttpStatus httpStatus, String detail) {
    this.httpStatus = httpStatus;
    this.detail = detail;
  }

  public String getDetail() {
    return detail;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
