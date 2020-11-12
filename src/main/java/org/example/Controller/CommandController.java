package org.example.Controller;

import org.example.core.Template;
import org.example.models.CommandCenter;
import org.example.models.CommandHistory;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.Map;

public class CommandController {
    private CommandCenter commandCenter;
    private CommandHistory commandHistory;

    public CommandController(CommandCenter commandCenter, CommandHistory commandHistory) {
        this.commandCenter = commandCenter;
        this.commandHistory = commandHistory;
    }

    public String chooseMenuCommand(Request req, Response res){
        Map<String, Object> model = new HashMap<>();
        model.put("orderUsers", commandCenter.getCommands());
        model.put("history", commandHistory.getHistory());
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
