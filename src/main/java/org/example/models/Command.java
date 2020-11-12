package org.example.models;

public class Command {
    public enum CommandState {
        NEW,
        IN_PROGRESS,
        FINISH,
        CANCELED
    }
}
