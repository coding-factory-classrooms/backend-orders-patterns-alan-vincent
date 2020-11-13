package org.example.service;

import org.example.models.OrdersManage;
import org.example.models.Order;

public class ManagerService {

    public boolean updateOrder(OrdersManage ordersManage, String id, String newState){
        try{
            Order order = ordersManage.getCommands().get(Integer.parseInt(id));
            switch (newState){
                case "NEW":
                    order.setStatus(Order.OrderState.NEW);
                        break;
                case "IN_PROGRESS":
                    order.setStatus(Order.OrderState.IN_PROGRESS);
                    break;
                case "FINISHED":
                    order.setStatus(Order.OrderState.FINISHED);
                    break;
                case "CANCELED":
                    order.setStatus(Order.OrderState.CANCELLED);
                    break;
                default:
                    return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public void updateHistoryOrders(OrdersManage ordersManage, String action){
        if(action.contentEquals("undo") || action.contentEquals("redo")){

            if(action.contentEquals("undo")
                    && ordersManage.history.getCurrentIndex() > 1
                    && ordersManage.history.getCurrentIndex() <=  ordersManage.history.getHistory().size())

                ordersManage.undo();
            else if(ordersManage.history.getCurrentIndex() >= 1 && ordersManage.history.getCurrentIndex() <=  ordersManage.history.getHistory().size()){
                ordersManage.redo();
            }
        }
        return;
    }
}
