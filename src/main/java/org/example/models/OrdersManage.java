package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrdersManage implements Order.HandleStateChange, Cloneable {

    private List<Order> orders;
    public CommandHistory history;

    public OrdersManage(CommandHistory history) {
        this.orders = new ArrayList<>();
        this.history = history;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void createOrder(Order newOrder) {
        orders.add(newOrder);
        newOrder.setHandleStateChange(this);
        history.push((OrdersManage) this.clone());
    }

    protected void setOrders(List<Order> newOrders){
        this.orders = newOrders;
    }

    @Override
    public Object clone() {
        OrdersManage ordersManage;
        try {
            ordersManage = (OrdersManage) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return null;
        }
        List<Order> clonedOrderList = (List) this.orders.stream().map(order -> order.clone()).collect(Collectors.toList());
        ordersManage.setOrders(clonedOrderList);
        return  ordersManage;
    }

    public boolean undo() {
        if (history.getHistory().isEmpty()) return false;
        executeCommand(new CommandUndo(this));
        return true;
    }

    public void redo(){
        if (history.getHistory().isEmpty()) return;
        executeCommand(new CommandRedo(this));
    }

    private void executeCommand(Command command) {
        if(command.execute())
            System.out.println("Command Executed");
        else
            System.out.println("Command Not Executed");
    }

    @Override
    public String toString(){
        String ordersString = "";
        int index = 0;
        for(Order order : orders){
            ordersString+="{"+index+","+order.toString()+"}";
            index+=1;
        }
        return "("+ordersString+")";
    }

    @Override
    public void onOrderStateChange(Order order) {
        history.push((OrdersManage) this.clone());
    }
}
