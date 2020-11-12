package org.example.Controller;

import org.example.core.Template;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class CommandController {
    public String chooseMenuCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        return Template.render("create_command.html",model);
    }

    public String createCommand(Request req, Response res){
        return "";
    }

    public String viewCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        return Template.render("view_command.html",model);
    }
}
