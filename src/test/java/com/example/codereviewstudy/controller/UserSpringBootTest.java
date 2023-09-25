package com.example.codereviewstudy.controller;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.codereviewstudy.domain.dto.SignupForm;
import com.example.codereviewstudy.domain.model.User;
import com.example.codereviewstudy.domain.repository.UserRepository;
import com.example.codereviewstudy.service.UserService;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSpringBootTest {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @BeforeEach
  public void setUp() {
    userRepository.deleteAll();
  }

  @Test
  void successUserTest() {
    User user = new User();
    user.createUser(1L, "test", "1234", LocalDateTime.now());
    userRepository.save(user);

    assertTrue(userRepository.existsByLoginId("test"));

    SignupForm signupForm = new SignupForm("test2", "1234");

    User signUser = userService.signupUser(signupForm);
    Assertions.assertEquals("test2", signUser.getLoginId());

    long userId = signUser.getId();
    Assertions.assertEquals(signUser, userService.searchUser(userId));
  }

  @Test
  void failUserTest() {
    User user = new User();
    user.createUser(1L, "test", "1234", LocalDateTime.now());
    userRepository.save(user);

    assertFalse(userRepository.existsByLoginId("test00"));

    SignupForm signupForm = new SignupForm("test2", "1234");

    User signUser = userService.signupUser(signupForm);
    Assertions.assertEquals("test2", signUser.getLoginId());

    assertThrows(RuntimeException.class, () -> userService.searchUser(5L));
  }
}