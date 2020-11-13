package org.example.service;

import org.example.Data;
import org.example.models.CommandCenter;
import org.example.models.CommandUser;
import org.example.models.Menu;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderService {
    public void createNewOrder(CommandCenter commandCenter, String menuChoose){
        Menu menu = Data.getData().stream().filter(_menu -> _menu.getTitle().contentEquals(menuChoose)).collect(Collectors.toList()).get(0);
        CommandUser newOrder = new CommandUser();
        newOrder.setOrderedMenu(menu);
        commandCenter.createCommand(newOrder);
    }
}
