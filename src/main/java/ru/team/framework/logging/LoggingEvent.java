package ru.team.framework.logging;

import org.springframework.context.ApplicationEvent;
import ru.team.framework.enums.ActionType;

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
