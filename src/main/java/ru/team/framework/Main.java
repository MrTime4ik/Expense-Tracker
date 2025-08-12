package ru.team.framework;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConf.class);

        CLIExpenseController cliExpenseController = context.getBean(CLIExpenseController.class);


//        cliExpenseController.add("dinner", 20, "eat");
//        cliExpenseController.add("lunch", 10, "eat");
//        cliExpenseController.add("breakfast", 15, "eat");
//        cliExpenseController.add("spa", 30, "relax");
        cliExpenseController.add("gta6", 250, "games");

//        cliExpenseController.update(3, "ps4", 1000);
    }
}