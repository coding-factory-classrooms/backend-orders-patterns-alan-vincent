package org.example.models;

public class CommandRedo extends Command{

    public CommandRedo(OrdersManage ordersManage) {
        super(ordersManage);
    }

    @Override
    public boolean execute() {
        try{
            int index = ordersManage.history.getCurrentIndex() -1;
            OrdersManage ordersManageRedo = (OrdersManage) ordersManage.history.getHistory().get(index+1).clone();
            ordersManage.getCommands().clear();

            ordersManage.setCommands(ordersManageRedo.getCommands());
            ordersManage.history.setCurrentIndex( ordersManage.history.getCurrentIndex() + 1);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
