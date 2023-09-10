package com.example.codereviewstudy.exception;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomException extends RuntimeException {
  private final UserErrorCode errorCode;
  private final int status;
  private static final ObjectMapper mapper = new ObjectMapper();

  public CustomException(UserErrorCode errorCode) {
    super(errorCode.getDetail());
    this.errorCode = errorCode;
    this.status = errorCode.getHttpStatus().value();
  }

  public UserErrorCode getErrorCode() {
    return this.errorCode;
  }

  public int getStatus() {
    return this.status;
  }

  public static class CustomExceptionResponse {
    private int status;
    private String code;
    private String message;

    public void setStatus(int status) {
      this.status = status;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public CustomExceptionResponse() {
    }


    public int getStatus() {
      return this.status;
    }

    public String getCode() {
      return this.code;
    }

    public String getMessage() {
      return this.message;
    }
  }
}