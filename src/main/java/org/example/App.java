package org.example;

import org.example.Controller.OrderController;
import org.example.Controller.HomeController;
import org.example.Controller.ManagerController;
import org.example.core.Conf;
import org.example.core.Template;
import org.example.middlewares.LoggerMiddleware;
import org.example.models.OrdersManage;
import org.example.models.CommandHistory;
import spark.Spark;

public class App {
    public static void main(String[] args) {
        initialize();

        CommandHistory history = new CommandHistory();
        OrdersManage ordersManage = new OrdersManage(history);
        history.push((OrdersManage) ordersManage.clone());

        HomeController homeController = new HomeController();
        OrderController orderController = new OrderController(ordersManage);
        ManagerController managerController = new ManagerController(ordersManage, history);

        Spark.get("/", (req, res) -> homeController.home(req,res));

        Spark.get("/order", (req, res) -> orderController.chooseMenuCommand(req,res));
        Spark.post("/order", (req, res) -> orderController.createOrder(req,res));
        Spark.get("/order/:id", (req, res) -> orderController.viewOrder(req,res));

        Spark.get("/manage", (req, res) -> managerController.manageOrderCommand(req,res));
        Spark.get("/manage/history", (req, res) -> managerController.updateHistory(req,res));
        Spark.get("/manage/update/:id", (req, res) -> managerController.updateCommand(req,res));
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
