package org.example;

import org.example.Controller.CommandController;
import org.example.Controller.HomeController;
import org.example.Controller.ManagerController;
import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import spark.Spark;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        initialize();

        HomeController homeController = new HomeController();
        CommandController commandController = new CommandController();
        ManagerController managerController = new ManagerController();

        Spark.get("/", (req, res) -> homeController.home(req,res));

        Spark.get("/command", (req, res) -> commandController.chooseMenuCommand(req,res));
        Spark.post("/command", (req, res) -> commandController.createCommand(req,res));
        Spark.get("/command/:id", (req, res) -> commandController.viewCommand(req,res));

        Spark.get("/manage", (req, res) -> managerController.manageOrderCommand(req,res));
        Spark.get("/manage/:id", (req, res) -> managerController.manageOneCommand(req,res));
        Spark.patch("/manage/update/:id", (req, res) -> managerController.updateCommand(req,res));
    }

    static void initialize() {
        Template.initialize();

        // Display exceptions in logs
        Spark.exception(Exception.class, (e, req, res) -> e.printStackTrace());

        // Serve static files (img/css/js)
        Spark.staticFiles.externalLocation(Conf.STATIC_DIR.getPath());

        // Configure server port
        Spark.port(Conf.HTTP_PORT);
        final LoggerMiddleware log = new LoggerMiddleware();
        Spark.before(log::process);
    }
}
