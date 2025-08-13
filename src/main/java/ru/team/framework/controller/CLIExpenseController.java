package ru.team.framework.controller;

import org.springframework.stereotype.Controller;
import ru.team.framework.enums.Currency;
import ru.team.framework.entity.Expense;

import java.util.Map;

@Controller
public class CLIExpenseController extends ExpenseController {

    @Override
    public Map<Integer, Expense> list() {
        return service.getAll();
    }

    @Override
    public Map<Integer, Expense> list(String category) {
        return service.getByCategory(category);
    }

    @Override
    public Map<Integer, Expense> list(Currency currency) {
        return service.getByCurrency(currency);
    }

    @Override
    public Map<Integer, Expense> listByMonth(String month) {
        return service.getByMonth(month);
    }


    @Override
    public boolean add(String description, int amount) {
        return service.add(new Expense(description, amount));
    }

    @Override
    public boolean add(String description, int amount, Currency currency) {
        return service.add(new Expense(description, amount, currency));
    }

    @Override
    public boolean add(String description, int amount, String category) {
        return service.add(new Expense(description, amount, category));
    }

    @Override
    public boolean add(String description, int amount, Currency currency, String category) {
        return service.add(new Expense(description, amount, currency, category));
    }


    @Override
    public boolean remove(int id) {
        return service.remove(id);
    }


    @Override
    public boolean update(int id, String description, int amount) {
        return service.update(id, new Expense(id, description, amount));
    }

    @Override
    public boolean update(int id, String description, int amount, Currency currency) {
        return service.update(id, new Expense(id, description, amount, currency));
    }

    @Override
    public boolean update(int id, String description, int amount,  String category) {
        return service.update(id, new Expense(id, description, amount, category));
    }

    @Override
    public boolean update(int id, String description, int amount, Currency currency, String category) {
        return service.update(id, new Expense(id, description, amount, currency, category));
    }
}
