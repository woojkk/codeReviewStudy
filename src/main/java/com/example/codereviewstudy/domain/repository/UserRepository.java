package com.example.codereviewstudy.domain.repository;

import com.example.codereviewstudy.domain.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  boolean existsByLoginId(String loginId);
}
