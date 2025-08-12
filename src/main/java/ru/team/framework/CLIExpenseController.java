package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    Map<Integer, Expense> list(Currency currency) {
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
    boolean add(String description, int amount, Currency currency) {
        return service.add(new Expense(description, amount, currency));
    }

    @Override
    public boolean add(String description, int amount, String category) {
        return service.add(new Expense(description, amount, category));
    }

    @Override
    boolean add(String description, int amount, Currency currency, String category) {
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
    boolean update(int id, String description, int amount, Currency currency) {
        return service.update(id, new Expense(id, description, amount, currency));
    }

    @Override
    public boolean update(int id, String description, int amount,  String category) {
        return service.update(id, new Expense(id, description, amount, category));
    }

    @Override
    boolean update(int id, String description, int amount, Currency currency, String category) {
        return service.update(id, new Expense(id, description, amount, currency, category));
    }
}
