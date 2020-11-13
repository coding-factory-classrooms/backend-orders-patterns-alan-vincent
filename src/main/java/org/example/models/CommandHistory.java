package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private final List<OrdersManage> history = new ArrayList<>();
    private int currentIndex;

    public CommandHistory() {
        currentIndex = 0;
    }

    public List<OrdersManage> getHistory() {
        return history;
    }

    public void push(OrdersManage command){
        history.add(command);
        currentIndex+=1;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
