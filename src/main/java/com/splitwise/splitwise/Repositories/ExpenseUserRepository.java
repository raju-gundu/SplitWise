package com.splitwise.splitwise.Repositories;

import com.splitwise.splitwise.Models.Expense;
import com.splitwise.splitwise.Models.ExpenseUser;
import com.splitwise.splitwise.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser,Long> {
    List<ExpenseUser> findByUser(User user);

}
