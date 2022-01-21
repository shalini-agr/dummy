package Controllers;

import Entities.Order;
import Managers.OrdersManager;
import com.google.gson.Gson;

import static spark.Spark.*;

public class OrderController {
    Gson gson;
    OrdersManager ordersManager;

    public OrderController() {
        gson = new Gson();
        ordersManager = new OrdersManager();
    }

    public void apis() {

        get("/orders", (req, res) -> {
            res.type("application/json");
            return ordersManager.getOrders();
        }, gson::toJson);

        get("/ordersOfUser/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return ordersManager.getOrdersOfUser(id);
        }, gson::toJson);

        get("/order/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return ordersManager.getOrderById(id);
        }, gson::toJson);

        post("/addOrder", (req, res) -> {
            res.type("application/json");
            Order order = gson.fromJson(req.body(), Order.class);
            return ordersManager.insert(order);
        }, gson::toJson);

        delete("/deleteOrder/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return ordersManager.delete(id);
        });
    }
}
