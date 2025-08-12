package ru.team.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

        CLIExpenseController cliExpenseController = context.getBean(CLIExpenseController.class);



//        cliExpenseController.add("dinner", 20, Currency.USD, "eat");
//        cliExpenseController.add("lunch", 10, Currency.USD, "eat");
//        cliExpenseController.add("breakfast", 15, Currency.RUB, "eat");
//        cliExpenseController.add("spa", 30, Currency.EUR, "relax");
//        cliExpenseController.add("gta6", 250, Currency.RUB, "games");
//        cliExpenseController.add("gta6", 250, Currency.CNY, "games");

//        cliExpenseController.add("dinner", 20, "eat");
//        cliExpenseController.add("lunch", 10, "eat");
//        cliExpenseController.add("breakfast", 15, "eat");
//        cliExpenseController.add("spa", 30, "relax");
        cliExpenseController.add("gta6", 250, Currency.JPY, "games");

//        cliExpenseController.list().forEach((id, expense) -> {
//            System.out.printf("%d -> %s\n", id, expense);
//        });

        cliExpenseController.list(Currency.JPY).forEach((id, currency) -> {
            System.out.printf("%d: %s\n", id, currency);
        });

//        cliExpenseController.remove(3);
    }
}