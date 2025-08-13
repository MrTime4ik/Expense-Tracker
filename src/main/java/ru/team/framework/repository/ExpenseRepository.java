package ru.team.framework.repository;

import ru.team.framework.entity.Expense;

import java.util.Map;


public abstract class ExpenseRepository {

    public abstract boolean save(Map<Integer, Expense> expenses);

    public abstract Map<Integer, Expense> load();

    public abstract boolean delete(int id);

    public abstract boolean update(int id, Expense newExpense);

    public abstract int getNewID();

}
