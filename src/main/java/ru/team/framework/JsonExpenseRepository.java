package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Repository
public class JsonExpenseRepository extends ExpenseRepository {


    ApplicationEventPublisher publisher;

    File dir = new File("E:/expenseData");
    File file = new File(dir,"expenses.json");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

    {
        if(!dir.exists()){
            dir.mkdir();
        }

        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Autowired
    public JsonExpenseRepository(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean save(Map<Integer, Expense> expenses) {

        if (expenses.size() == 1) {

            Map<Integer, Expense> allExpenses = load();

            try (FileWriter fw = new FileWriter(file, false)) {

                allExpenses.putAll(expenses);

                for(Expense expense : allExpenses.values()) {
                    fw.append(expense.toString()).append("\n");
                }
                publisher.publishEvent(new LoggingEvent(expenses, ActionType.SAVE));
                return true;

            } catch (IOException e) {
                return false;
            }
        } else {
            try (FileWriter fw = new FileWriter(file, false)) {

                Map<Integer, Expense> allExpenses = load();
                allExpenses.putAll(expenses);

                for(Expense expense : allExpenses.values()) {
                    fw.append(expense.toString()).append("\n");
                }
                publisher.publishEvent(new LoggingEvent(expenses, ActionType.SAVE));
                return true;

            } catch (IOException e) {
                return false;
            }
        }
    }

    @Override
    public Map<Integer, Expense> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            Map<Integer, Expense> expenses = new TreeMap<>();
            reader.lines().forEach(line -> {

                String[] expenseData = line.split(";");

                int id = Integer.parseInt(expenseData[0].split("=")[1]);
                String description = expenseData[1].split("=")[1];
                int amount = Integer.parseInt(expenseData[2].split("=")[1]);
                LocalDateTime date = LocalDateTime.parse(expenseData[3].split("=")[1], formatter);
                String category = expenseData[4].split("=")[1];

                expenses.put(id, new Expense(id, description, amount, date, category));

            });

            publisher.publishEvent(new LoggingEvent(expenses, ActionType.LOAD));
            return expenses;

        } catch (IOException e) {
            return null;
        }
    }

    @Override
    public boolean delete(int id) {
        Map<Integer, Expense> expenses = load();
        expenses.remove(id);
        save(expenses);

        publisher.publishEvent(new LoggingEvent(expenses, ActionType.DELETE));
        return true;
    }

    @Override
    public boolean update(int id, Expense newExpense) {
        Map<Integer, Expense> expenses = load();
        expenses.remove(id);
        expenses.put(id, newExpense);
        save(expenses);

        publisher.publishEvent(new LoggingEvent(expenses, ActionType.UPDATE));
        return true;
    }

    public int getNewID() {
        Map<Integer, Expense> expenses = load();
        if (!expenses.isEmpty()) {
            List<Integer> IDs = new LinkedList<>(expenses.keySet());
            int maxID = Collections.max(IDs);
            if(expenses.size() == maxID) {
                return maxID + 1;
            }

            for (int i = 1; i <= expenses.size(); i++) {
                if (!expenses.containsKey(i)) {
                    return i;
                }
            }
        }
        return 1;
    }
}
