package org.example.service;

import org.example.Data;
import org.example.models.OrdersManage;
import org.example.models.Menu;
import org.example.models.Order;

import java.util.stream.Collectors;

public class OrderService {
    public void createNewOrder(OrdersManage ordersManage, String menuChoose){
        Menu menu = Data.getData().stream().filter(_menu -> _menu.getTitle().contentEquals(menuChoose)).collect(Collectors.toList()).get(0);
        Order newOrder = new Order();
        newOrder.setOrderedMenu(menu);
        ordersManage.createOrder(newOrder);
    }
}
