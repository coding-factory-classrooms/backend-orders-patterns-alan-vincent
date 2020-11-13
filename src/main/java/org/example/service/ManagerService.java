package org.example.service;

import org.example.models.CommandCenter;
import org.example.models.CommandUser;

public class ManagerService {

    public boolean updateOrder(CommandCenter commandCenter,String id, String newState){
        try{
            CommandUser order = commandCenter.getCommands().get(Integer.parseInt(id));
            switch (newState){
                case "NEW":
                    order.setStatus(CommandUser.CommandState.NEW);
                        break;
                case "IN_PROGRESS":
                    order.setStatus(CommandUser.CommandState.IN_PROGRESS);
                    break;
                case "FINISHED":
                    order.setStatus(CommandUser.CommandState.FINISHED);
                    break;
                case "CANCELED":
                    order.setStatus(CommandUser.CommandState.CANCELLED);
                    break;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
