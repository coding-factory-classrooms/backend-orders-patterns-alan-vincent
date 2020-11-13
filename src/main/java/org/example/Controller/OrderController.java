package org.example.Controller;

import org.example.Data;
import org.example.core.Template;
import org.example.models.Order;
import org.example.models.OrdersManage;
import org.example.service.OrderService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class OrderController {
    private OrdersManage ordersManage;

    public OrderController(OrdersManage ordersManage) {
        this.ordersManage = ordersManage;
    }

    public String chooseMenuCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("menus", Data.getData());
        return Template.render("create_order.html",model);
    }

    public String createOrder(Request req, Response res){
        if(req.body() == "" || req.body().contentEquals("NONE")){
            res.status(400);
            return"";
        }
        OrderService orderService = new OrderService();
        orderService.createNewOrder(ordersManage, req.body());
        int id = ordersManage.getOrders().size()-1;
        res.status(200);
        return Integer.toString(id);
    }

    public String viewOrder(Request req, Response res){
        String id = req.params(":id");
        try {
            Order order = ordersManage.getOrders().get(Integer.parseInt(id));
            Map<String, Object> model = new HashMap<>();
            model.put("id", id);
            model.put("order",order);
            return Template.render("view_order.html",model);
        }
        catch(Exception e) {
            System.out.println(e);
            res.redirect("/order");
            return "";
        }
    }
}
