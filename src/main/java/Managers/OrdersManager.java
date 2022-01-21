package Managers;

import Entities.Order;
import Handlers.MorphiaHandler;

import java.util.List;

public class OrdersManager {

    MorphiaHandler morphiaHandler;

    public OrdersManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public String insert(Order order) {
        return morphiaHandler.insertOrder(order);
    }

    public List<Order> getOrders() {
        return morphiaHandler.getOrders();
    }

    public List<Order> getOrdersOfUser(int id) {
        return morphiaHandler.getOrdersOfUser(id);
    }

    public List<Order> getOrderById(int id) {
        return morphiaHandler.getOrderById(id);
    }

    public String delete(int id) {
        morphiaHandler.deleteOrderById(id);
        return "order deleted";
    }
}
