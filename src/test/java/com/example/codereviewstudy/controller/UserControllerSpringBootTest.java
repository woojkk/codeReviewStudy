package com.example.codereviewstudy.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.codereviewstudy.domain.model.User;
import com.example.codereviewstudy.domain.repository.UserRepositoryImpl;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserControllerSpringBootTest {

  @Autowired
  private UserRepositoryImpl userRepository;

  @BeforeEach
  public void repository() {
    userRepository = new UserRepositoryImpl();
  }

  @Test
  @DisplayName("회원 가입")
  public void signupUserTest() {
    User user = new User();
    user.createUser(1L, "test", "1234", LocalDateTime.now());
    User saveUser = userRepository.save(user);

    boolean exists = userRepository.existsByLoginId(user.getLoginId());
    assertTrue(exists);

    exists = userRepository.existsByLoginId("test000");
    assertFalse(exists);

    Assertions.assertEquals(saveUser.getId(), user.getId());

    Assertions.assertEquals(saveUser.getLoginId(), user.getLoginId());
  }

  @Test
  @DisplayName("사용자 조회")
  public void searchUserTest() {
    User user = new User();
    user.createUser(1L, "test", "1234", LocalDateTime.now());
    User saveUser = userRepository.save(user);

    User findUser = userRepository.findById(saveUser.getId())
        .orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다."));

    assertThat(findUser.getId()).isEqualTo(user.getId());

    assertThrows(RuntimeException.class, () ->
        userRepository.findById(100L)
            .orElseThrow(() -> new RuntimeException("아이디가 존재하지 않습니다.")));

    Assertions.assertEquals(saveUser.getId(), user.getId());

    Assertions.assertEquals(saveUser.getLoginId(), user.getLoginId());
  }
}