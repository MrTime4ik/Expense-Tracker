package ru.team.framework.logging;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LoggingListener {

    @EventListener(LoggingEvent.class)
    public void acceptLogs(LoggingEvent event) {
        System.out.println(event.getActionType().getAction());
    }

}
