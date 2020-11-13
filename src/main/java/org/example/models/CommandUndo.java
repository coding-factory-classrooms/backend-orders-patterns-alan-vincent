package org.example.models;

public class CommandUndo extends Command {

    public CommandUndo(OrdersManage ordersManage) {
        super(ordersManage);
    }

    @Override
    public boolean execute() {
        try{
            int index = ordersManage.history.getCurrentIndex() -1;
            OrdersManage ordersManageRedo = (OrdersManage)ordersManage.history.getHistory().get(index-1).clone();
            ordersManage.getOrders().clear();
            ordersManage.setOrders(ordersManageRedo.getOrders());
            ordersManage.history.setCurrentIndex(index);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
