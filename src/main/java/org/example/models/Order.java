package org.example.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Order implements Cloneable {
    public enum OrderState {
        NEW,
        IN_PROGRESS,
        FINISHED,
        CANCELLED
    }

    public interface handleStateChange {
        void onOrderStateChange(Order order);
    }

    private OrderState status;
    private Menu orderdMenu;
    private handleStateChange handleStateChange;

    public Order() {
        this.status = OrderState.NEW;
    }

    public OrderState getStatus() {
        return status;
    }

    public void setStatus(OrderState status) {
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

    public void setHandleStateChange(Order.handleStateChange handleStateChange) {
        this.handleStateChange = handleStateChange;
    }

    @Override
    public Object clone() {
        Order cloneOrder = new Order();
        try {
            cloneOrder = (Order) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        cloneOrder.setOrderedMenu((Menu) orderdMenu.clone());
        return cloneOrder;
    }

    @Override
    public String toString(){
        String menuString = "";
        int index = 0;
        for(Foodtray foodtray : orderdMenu.getFoodtrays()){
            menuString+="{"+index+","+foodtray.getDescription()+","+foodtray.toString()+"}";
            index+=1;
        }
        return "("+menuString+","+getStatus()+")";
    }
}
