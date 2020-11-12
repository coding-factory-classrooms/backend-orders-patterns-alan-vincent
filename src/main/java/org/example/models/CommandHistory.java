package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private final List<CommandCenter> history = new ArrayList<>();

    public CommandHistory() {
    }

    public List<CommandCenter> getHistory() {
        return history;
    }

    public void push(CommandCenter command){
        history.add(command);
    }
}
