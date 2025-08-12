package ru.team.framework;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Expense {

    private int id;
    private String description;
    private int amount;
    private LocalDateTime date;
    private String category;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");

    private ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

    public Expense(String description, int amount, String category) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(String description, int amount) {
        this.id = context.getBean(ExpenseRepository.class).getNewID();
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(int id, String description, int amount, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.category = category;
    }

    public Expense(int id, String description, int amount) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.date = LocalDateTime.now();
        this.category = "none";
    }

    public Expense(int id, String description, int amount, LocalDateTime date, String category) {
        this.id = id;
        this.description = description;
        this.amount = amount;
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

    @Override
    public String toString() {
        return String.format("id=%d;description=%s;amount=%d;date=%s;category=%s", id, description, amount, date.format(formatter), category);
    }

}
