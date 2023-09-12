package com.example.codereviewstudy.domain.repository;

import com.example.codereviewstudy.domain.model.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
  private final Map<Long, User> userMap = new HashMap<>();
  private final AtomicLong currentUserId = new AtomicLong();

  @Override
  public User save(User user) {
    long userId = this.currentUserId.incrementAndGet();
    user.createUserId(userId);
    userMap.put(userId, user);
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
