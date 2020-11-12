package org.example.models;

public abstract class Command {
    public CommandCenter commandCenter;

    public Command(CommandCenter commandCenter) {
        this.commandCenter = commandCenter;
    }

    public void undo(){

    }

    public void redo(){

    }

    public abstract boolean execute();
}
