package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public abstract class ExpenseService {

    @Autowired
    protected ExpenseRepository repository;

    abstract boolean add(Expense expense);

    abstract Map<Integer, Expense> getAll();

    abstract Map<Integer, Expense> getByCategory(String category);

    abstract Map<Integer, Expense> getByMonth(String month);

    abstract boolean remove(int id);

    abstract boolean update(int id, Expense newExpense);

}
