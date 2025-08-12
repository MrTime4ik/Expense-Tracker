package ru.team.framework;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.event.ActionEvent;

@Component
public class LoggingListener {

    @EventListener(LoggingEvent.class)
    public void acceptLogs(LoggingEvent event) {
        System.out.println(event.getActionType().getAction());
    }

}
