package com.splitwise.splitwise.Repositories;

import com.splitwise.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long userId);
}
