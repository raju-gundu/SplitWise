package com.splitwise.splitwise.Repositories;

import com.splitwise.splitwise.Models.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group,Long> {

    Optional<Group> findById(Long id);
}
