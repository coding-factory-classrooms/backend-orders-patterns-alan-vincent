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

    public interface handleStateChange {
        void onOrderStateChange(CommandUser commandUser);
    }

    private CommandState status;
    private Menu orderdMenu;
    private handleStateChange handleStateChange;

    public CommandUser() {
        this.status = CommandState.NEW;
    }

    public CommandState getStatus() {
        return status;
    }

    public void setStatus(CommandState status) {
        this.status = status;
        if(handleStateChange != null){
            handleStateChange.onOrderStateChange(this);
        }
    }

    public Menu getOrderedMenu() {
        return orderdMenu;
    }

    public void setOrderedMenu(Menu commandFoods) {
        this.orderdMenu = commandFoods;
    }

    public void setHandleStateChange(CommandUser.handleStateChange handleStateChange) {
        this.handleStateChange = handleStateChange;
    }
}
