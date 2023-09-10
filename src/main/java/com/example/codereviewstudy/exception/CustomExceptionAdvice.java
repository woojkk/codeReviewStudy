package com.example.codereviewstudy.exception;

import com.example.codereviewstudy.exception.CustomException.CustomExceptionResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {

  @ExceptionHandler(CustomException.class)
  public ResponseEntity<CustomException.CustomExceptionResponse> exceptionHandler(
      HttpServletRequest request, CustomException exception) {
    CustomException.CustomExceptionResponse response = new CustomExceptionResponse();

    response.setStatus(exception.getStatus());
    response.setCode(exception.getErrorCode().name());
    response.setMessage(exception.getMessage());

    return ResponseEntity
        .status(exception.getStatus())
        .body(response);
  }
}
