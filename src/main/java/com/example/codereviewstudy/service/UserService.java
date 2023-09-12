package com.example.codereviewstudy.service;

import com.example.codereviewstudy.domain.dto.SignupForm;
import com.example.codereviewstudy.domain.model.User;
import com.example.codereviewstudy.domain.repository.UserRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User signupUser(SignupForm signupForm) {

    boolean isLoginId = userRepository.existsByLoginId(signupForm.getLoginId());
    if (isLoginId) {
      throw new RuntimeException("이미 해당 아이디가 존재합니다.");
    }

    User user = new User();
    user.createUser(user.getId(), signupForm.getLoginId(),signupForm.getPassword(),LocalDateTime.now());

    return userRepository.save(user);
  }

  public User searchUser(long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new RuntimeException("해당 아이디를 찾을 수 없습니다."));
  }
}
