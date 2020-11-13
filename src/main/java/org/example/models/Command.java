package org.example.models;

public abstract class Command {
    public OrdersManage ordersManage;

    public Command(OrdersManage ordersManage) {
        this.ordersManage = ordersManage;
    }

    public abstract boolean execute();
}
