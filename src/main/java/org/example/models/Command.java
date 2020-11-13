package org.example.models;

public abstract class Command {
    public OrdersManage ordersManage;

    public Command(OrdersManage ordersManage) {
        this.ordersManage = ordersManage;
    }

    public void undo(){

    }

    public void redo(){

    }

    public abstract boolean execute();
}
