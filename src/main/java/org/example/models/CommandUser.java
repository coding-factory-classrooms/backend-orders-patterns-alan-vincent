package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandUser {
    public enum CommandState {
        NEW,
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    private CommandState status;
    private List<Foodtray> commandFoods;

    public CommandUser() {
        this.commandFoods = new ArrayList<>();
        this.status = CommandState.NEW;
    }

    public CommandState getStatus() {
        return status;
    }

    public void setStatus(CommandState status) {
        this.status = status;
    }

    public List<Foodtray> getCommandFoods() {
        return commandFoods;
    }

    public void setCommandFoods(List<Foodtray> commandFoods) {
        this.commandFoods = commandFoods;
    }

    public void addCommandFoods(Foodtray foodtray) {
        this.commandFoods.add(foodtray);
    }

}
