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
        return morphiaHandler.insert(order);
    }

    public List<Object> getOrders() {
        return morphiaHandler.getAllDocs(Order.class);
    }

    public List<Order> getOrdersOfUser(int id) {
        return morphiaHandler.getOrdersOfUser(id);
    }

    public List<Object> getOrderById(int id) {
        return morphiaHandler.getObjById(id, Order.class);
    }

    public String delete(int id) {
        morphiaHandler.delete(id, Order.class);
        return "order deleted";
    }
}
