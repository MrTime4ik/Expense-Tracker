package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public abstract class ExpenseController {

    @Autowired
    protected ExpenseService service;

    abstract Map<Integer, Expense> list();
    abstract Map<Integer, Expense> list(String category);
    abstract Map<Integer, Expense> listByMonth(String month);

    abstract boolean add(String description, int amount);
    abstract boolean add(String description, int amount, String category);


    abstract boolean remove(int id);
    abstract boolean update(int id, String description, int amount);
    abstract boolean update(int id, String description, int amount, String category);
}
