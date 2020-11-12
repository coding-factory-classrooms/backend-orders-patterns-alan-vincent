package org.example.Controller;

import org.example.core.Template;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class ManagerController {
    public String manageOrderCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        return Template.render("command_manager.html",model);
    }

    public String manageOneCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        return Template.render("command_updater.html",model);
    }

    public String updateCommand(Request req, Response res){
        return "";
    }
}
