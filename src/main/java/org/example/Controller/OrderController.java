package org.example.Controller;

import org.example.Data;
import org.example.core.Template;
import org.example.models.CommandCenter;
import org.example.models.CommandHistory;
import org.example.models.CommandUser;
import org.example.service.OrderService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class OrderController {
    private CommandCenter commandCenter;

    public OrderController(CommandCenter commandCenter) {
        this.commandCenter = commandCenter;
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
        orderService.createNewOrder(commandCenter, req.body());
        int id = commandCenter.getCommands().size()-1;
        res.status(200);
        return Integer.toString(id);
    }

    public String viewOrder(Request req, Response res){
        String id = req.params(":id");
        System.out.println(id);
        try {
            CommandUser order = commandCenter.getCommands().get(Integer.parseInt(id));
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
