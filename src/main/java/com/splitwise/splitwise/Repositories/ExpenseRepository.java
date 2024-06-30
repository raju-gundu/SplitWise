package com.splitwise.splitwise.Repositories;

import com.splitwise.splitwise.Models.Expense;
import com.splitwise.splitwise.Models.Group;
import com.splitwise.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
    List<Expense> findAllByGroup(Group group);
    List<Expense> findAllByUser(User user);
}
