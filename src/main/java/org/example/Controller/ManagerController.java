package org.example.Controller;

import org.example.core.Template;
import org.example.models.OrdersManage;
import org.example.models.CommandHistory;
import org.example.service.ManagerService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ManagerController {
    private OrdersManage ordersManage;
    private CommandHistory commandHistory; //TODO : retirer

    public ManagerController(OrdersManage ordersManage, CommandHistory commandHistory) {
        this.ordersManage = ordersManage;
        this.commandHistory = commandHistory; //TODO : retirer
    }

    public String manageOrderCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("orderUsers", ordersManage.getOrders());
        model.put("history", commandHistory.getHistory());
        model.put("currentHistory", commandHistory.getCurrentIndex());
        return Template.render("command_manager.html",model);
    }

    public String updateCommand(Request req, Response res){
        String id = req.params(":id");
        String action = req.queryParamOrDefault("action", "");
        if(action != "" && id != ""){
            ManagerService managerService = new ManagerService();
            managerService.updateOrder(ordersManage, id, action);
        }

        res.redirect("/manage");
        return "";
    }

    public String updateHistory(Request req, Response res){
        String action = req.queryParamOrDefault("action", "");
        if(action != ""){
            ManagerService managerService = new ManagerService();
            managerService.updateHistoryOrders(ordersManage, action);
        }

        res.redirect("/manage");
        return "";
    }
}
