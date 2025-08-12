package ru.team.framework;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SimpleExpenseService extends ExpenseService {

    @Override
    public boolean add(Expense expense) {
        return repository.save(Map.of(expense.getId(), expense));
    }

    @Override
    public Map<Integer, Expense> getAll() {
        return repository.load();
    }

    @Override
    public Map<Integer, Expense> getByCategory(String category) {
        Map<Integer, Expense> expenses = new TreeMap<>();
        for (Expense expense : getAll().values()) {
            if (expense.getCategory().equals(category)) {
                expenses.put(expense.getId(), expense);
            }
        }
        return expenses;
    }

    @Override
    public Map<Integer, Expense> getByMonth(String month) {
        Map<Integer, Expense> expenses = new TreeMap<>();

        month = month.toLowerCase();
        int monthNum = switch (month) {
            case "январь" -> 1;
            case "февраль" -> 2;
            case "март" -> 3;
            case "апрель" -> 4;
            case "май" -> 5;
            case "июнь" -> 6;
            case "июль" -> 7;
            case "август" -> 8;
            case "сентябрь" -> 9;
            case "октябрь" -> 10;
            case "ноябрь" -> 11;
            case "декабрь" -> 12;
            default -> 0;
        };

        int currentMonth;

        for (Expense expense : getAll().values()) {

            currentMonth = expense.getDate().getMonth().getValue();
            if (monthNum == currentMonth) {
                expenses.put(expense.getId(), expense);
            }
        }
        return expenses;
    }

    @Override
    public boolean remove(int id) {
        return repository.delete(id);
    }

    @Override
    boolean update(int id, Expense newExpense) {
        return repository.update(id, newExpense);
    }
}
