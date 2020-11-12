package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandCenter {

    private final List<CommandUser> commandUsers;
    private final CommandHistory history;

    public CommandCenter(CommandHistory history) {
        this.commandUsers = new ArrayList<>();
        this.history = history;
    }

    public List<CommandUser> getCommands() {
        return commandUsers;
    }

    public void createCommand(CommandUser command){
        this.commandUsers.add(command);
        history.push(this);
    }
}
