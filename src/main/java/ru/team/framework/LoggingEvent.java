package ru.team.framework;

import org.springframework.context.ApplicationEvent;

public class LoggingEvent extends ApplicationEvent {

    private final ActionType actionTypeType;

    public LoggingEvent(Object source, ActionType actionTypeType) {
        super(source);
        this.actionTypeType = actionTypeType;
    }

    public ActionType getActionType() {
        return actionTypeType;
    }
}
