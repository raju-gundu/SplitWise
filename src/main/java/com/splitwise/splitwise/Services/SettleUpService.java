package com.splitwise.splitwise.Services;

import com.splitwise.splitwise.Models.Expense;
import com.splitwise.splitwise.Models.ExpenseUser;
import com.splitwise.splitwise.Models.Group;
import com.splitwise.splitwise.Models.User;
import com.splitwise.splitwise.Repositories.ExpenseRepository;
import com.splitwise.splitwise.Repositories.ExpenseUserRepository;
import com.splitwise.splitwise.Repositories.GroupRepository;
import com.splitwise.splitwise.Repositories.UserRepository;
import com.splitwise.splitwise.Stratergies.SettleUpStratergy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class SettleUpService {
    private GroupRepository groupRepository;
    private ExpenseRepository expenseRepository;
    private SettleUpStratergy settleUpStratergy;
    private UserRepository userRepository;
    private ExpenseUserRepository expenseUserRepository;

    @Autowired
    public SettleUpService(GroupRepository groupRepository, ExpenseRepository expenseRepository, SettleUpStratergy settleUpStratergy, UserRepository userRepository, ExpenseUserRepository expenseUserRepository) {
        this.groupRepository = groupRepository;
        this.expenseRepository = expenseRepository;
        this.settleUpStratergy = settleUpStratergy;
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
    }

    public List<Expense> settleUpUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()){
            throw new RuntimeException();
        }
        User user = optionalUser.get();
        List<ExpenseUser> expenseUsers = expenseUserRepository.findByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expenses.add(expenseUser.getExpense());
        }

        List<Expense> expensesToSettle = settleUpStratergy.settleUp(expenses.stream().toList());

        List<Expense> expensesToReturn = new ArrayList<>();
        for (Expense expense : expensesToSettle) {
            for (ExpenseUser expenseUser : expense.getExpenseUsers()) {
                if (expenseUser.getUser().equals(user)) {
                    expensesToReturn.add(expense);
                }
            }
        }

        return expensesToReturn;
    }
    public List<Expense> settleUpGroup(Long groupId){
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isEmpty()){
            throw new RuntimeException();
        }
        Group group = optionalGroup.get();

        List<Expense> expenses = expenseRepository.findAllByGroup(group);

        List<Expense> expensesToReturn = settleUpStratergy.settleUp(expenses);

        return expensesToReturn;
    }
}
