package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private List<OrdersManage> history = new ArrayList<>();
    private int currentIndex;

    public CommandHistory() {
        currentIndex = 0;
    }

    public List<OrdersManage> getHistory() {
        return history;
    }

    public void push(OrdersManage command){
        if(history.size() == currentIndex){
            currentIndex+=1;
        }else{
            currentIndex = history.size();
            history = history.subList(0,currentIndex-1);
        }
        System.out.println(history);
        history.add(command);

    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
}
