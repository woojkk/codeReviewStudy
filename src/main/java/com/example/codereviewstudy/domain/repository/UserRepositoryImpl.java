package com.example.codereviewstudy.domain.repository;

import com.example.codereviewstudy.domain.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
  private final Map<Long, User> userMap = new HashMap<>();
  @Override
  public User save(User user) {
    userMap.put(user.getId(), user);
    return user;
  }

  @Override
  public boolean existsByLoginId(String loginId) {
    return userMap.values().stream()
        .anyMatch(user -> user.getLoginId().equals(loginId));
  }

  @Override
  public Optional<User> findById(Long id) {
    return Optional.ofNullable(userMap.get(id));
  }

}
