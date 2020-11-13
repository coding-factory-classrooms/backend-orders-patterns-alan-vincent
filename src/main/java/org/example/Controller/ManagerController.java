package org.example.Controller;

import org.example.core.Template;
import org.example.models.CommandCenter;
import org.example.models.CommandHistory;
import org.example.service.ManagerService;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ManagerController {
    private CommandCenter commandCenter;
    private CommandHistory commandHistory;

    public ManagerController(CommandCenter commandCenter, CommandHistory commandHistory) {
        this.commandCenter = commandCenter;
        this.commandHistory = commandHistory;
    }

    public String manageOrderCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("orderUsers", commandCenter.getCommands());
        model.put("history", commandHistory.getHistory());
        return Template.render("command_manager.html",model);
    }

    public String manageOneCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        return Template.render("command_updater.html",model);
    }

    public String updateCommand(Request req, Response res){
        String id = req.params(":id");
        String action = req.queryParamOrDefault("action", "");
        if(action != "" && id != ""){
            if(action.contentEquals("NEW") || action.contentEquals("IN_PROGRESS") || action.contentEquals("FINISHED") ||  action.contentEquals("CANCELED")){
                try{
                    ManagerService managerService = new ManagerService();
                    managerService.updateOrder(commandCenter, id, action);
                }catch (Exception e){
                    System.out.println(e);
                }
            }
        }

        res.redirect("/manage");
        return "";
    }
}
