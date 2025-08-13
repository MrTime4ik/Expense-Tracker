package ru.team.framework.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.team.framework.enums.Currency;
import ru.team.framework.entity.Expense;
import ru.team.framework.repository.ExpenseRepository;

import java.util.Map;


public abstract class ExpenseService {

    @Autowired
    protected ExpenseRepository repository;

    public abstract boolean add(Expense expense);

    public abstract Map<Integer, Expense> getAll();

    public abstract Map<Integer, Expense> getByCategory(String category);

    public abstract Map<Integer, Expense> getByCurrency(Currency currency);

    public abstract Map<Integer, Expense> getByMonth(String month);

    public abstract boolean remove(int id);

    public abstract boolean update(int id, Expense newExpense);

}
