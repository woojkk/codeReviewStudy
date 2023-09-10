package com.example.codereviewstudy.service;

import com.example.codereviewstudy.domain.dto.SignupForm;
import com.example.codereviewstudy.domain.model.User;
import com.example.codereviewstudy.domain.repository.UserRepository;
import com.example.codereviewstudy.exception.CustomException;
import com.example.codereviewstudy.exception.UserErrorCode;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User signupUser(SignupForm signupForm) {

    if (userRepository.existsByLoginId(signupForm.getLoginId())) {
      throw new CustomException(UserErrorCode.ALREADY_EXIST_LOGINID);
    }

    User user = new User();
    String loginId = signupForm.getLoginId();
    String password = signupForm.getPassword();
    user.setLoginId(loginId);
    user.setPassword(password);
    user.setCreatedAt(LocalDateTime.now());

    return userRepository.save(user);
  }

  public User searchUser(long userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new CustomException(UserErrorCode.NOT_FOUND_LOGINID));
  }
}
