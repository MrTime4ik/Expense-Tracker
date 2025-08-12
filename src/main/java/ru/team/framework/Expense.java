package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Expense {

    private int id;
    private String description;
    private int amount;

    private Currency currency;
    private LocalDateTime date;
    private String category;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

    public Expense(String description, int amount, String category) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.currency = Currency.USD;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(String description, int amount, Currency currency, String category) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(String description, int amount) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.currency = Currency.USD;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(String description, int amount, Currency currency) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(int id, String description, int amount, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = Currency.USD;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(int id, String description, int amount, Currency currency, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(int id, String description, int amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = Currency.USD;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(int id, String description, int amount, Currency currency) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(int id, String description, int amount, Currency currency, LocalDateTime date, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.category = category;
    }



    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public int getId() {
        return id;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }


    @Override
    public String toString() {
        return String.format("id=%d;description=%s;amount=%d;currency=%s;date=%s;category=%s", id, description, amount, currency.getCurrency(), date.format(formatter), category);
    }

    public static Map<Integer, Expense> parse(Stream<String> lines) {
        Map<Integer, Expense> expenses = new TreeMap<>();
        lines.forEach(line -> {

            String[] expenseData = line.split(";");

            int id = Integer.parseInt(expenseData[0].split("=")[1]);
            String description = expenseData[1].split("=")[1];
            int amount = Integer.parseInt(expenseData[2].split("=")[1]);
            Currency currency = Currency.getCurrency(expenseData[3].split("=")[1]);
            LocalDateTime date = LocalDateTime.parse(expenseData[4].split("=")[1], formatter);
            String category = expenseData[5].split("=")[1];

            expenses.put(id, new Expense(id, description, amount, currency, date, category));

        });
        return expenses;
    }

}
