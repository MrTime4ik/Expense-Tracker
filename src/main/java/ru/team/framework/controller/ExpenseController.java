package ru.team.framework.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ru.team.framework.enums.Currency;
import ru.team.framework.entity.Expense;
import ru.team.framework.service.ExpenseService;

import java.util.Map;

public abstract class ExpenseController {

    @Autowired
    protected ExpenseService service;

    public abstract Map<Integer, Expense> list();
    public abstract Map<Integer, Expense> list(String category);
    public abstract Map<Integer, Expense> list(Currency currency);
    public abstract Map<Integer, Expense> listByMonth(String month);

    public abstract boolean add(String description, int amount);
    public abstract boolean add(String description, int amount, Currency currency);
    public abstract boolean add(String description, int amount, String category);
    public abstract boolean add(String description, int amount, Currency currency, String category);

    public abstract boolean remove(int id);

    public abstract boolean update(int id, String description, int amount);
    public abstract boolean update(int id, String description, int amount, Currency currency);
    public abstract boolean update(int id, String description, int amount, String category);
    public abstract boolean update(int id, String description, int amount, Currency currency, String category);
}
