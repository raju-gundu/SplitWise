package com.splitwise.splitwise.Stratergies;

import com.splitwise.splitwise.Models.Expense;

import java.util.List;

public interface SettleUpStratergy {
    public List<Expense> settleUp(List<Expense> expenses);
}
