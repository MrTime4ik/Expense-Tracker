package ru.team.framework;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


public abstract class ExpenseRepository {

    abstract boolean save(Map<Integer, Expense> expenses);

    abstract Map<Integer, Expense> load();

    abstract boolean delete(int id);

    public abstract boolean update(int id, Expense newExpense);

    public abstract int getNewID();

}
