package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandCenter implements CommandUser.handleStateChange, Cloneable {

    private final List<CommandUser> commandUsers;
    private final CommandHistory history;

    public CommandCenter(CommandHistory history) {
        this.commandUsers = new ArrayList<>();
        this.history = history;
    }

    public List<CommandUser> getCommands() {
        return commandUsers;
    }

    public void createCommand(CommandUser command) {
        commandUsers.add(command);
        command.setHandleStateChange(this);
        history.push((CommandCenter) this.clone());
    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch(CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return o;
    }

    @Override
    public void onOrderStateChange(CommandUser commandUser) {
        history.push((CommandCenter) this.clone());
    }
}
