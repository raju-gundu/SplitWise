package com.splitwise.splitwise.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "ExpenseGroup")
public class Group extends BaseModel{
    private String name;

    @ManyToMany
    private List<User> users;

    @OneToMany(mappedBy = "group")
    private List<Expense> expense;

    @ManyToOne
    private User createdBy;
}
