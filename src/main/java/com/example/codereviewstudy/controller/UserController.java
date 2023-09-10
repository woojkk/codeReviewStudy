package com.example.codereviewstudy.controller;

import com.example.codereviewstudy.domain.dto.SignupForm;
import com.example.codereviewstudy.domain.dto.UserDto;
import com.example.codereviewstudy.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public ResponseEntity<UserDto> signupUser(@RequestBody SignupForm signupForm) {
    return ResponseEntity.ok(
        UserDto.from(userService.signupUser(signupForm)));
  }

  @GetMapping("/{userId}")
  public ResponseEntity<?> searchUser(@PathVariable long userId) {
    return ResponseEntity.ok(
        userService.searchUser(userId));
  }
}
