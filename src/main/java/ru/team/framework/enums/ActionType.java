package ru.team.framework.enums;

public enum ActionType {

    SAVE,
    LOAD,
    UPDATE,
    DELETE;

    private final String action;
    ActionType() {
        this.action = this.name();
    }

    public String getAction() {
        return action;
    }

}
