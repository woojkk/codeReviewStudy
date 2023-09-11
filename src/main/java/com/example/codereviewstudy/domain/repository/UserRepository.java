package com.example.codereviewstudy.domain.repository;

import com.example.codereviewstudy.domain.model.User;
import java.util.Optional;

public interface UserRepository {

  boolean existsByLoginId(String loginId);

  Optional<User> findById(Long id);

  User save(User user);
}
