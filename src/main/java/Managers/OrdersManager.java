package Managers;

import Entities.Order;
import Entities.Product;
import Entities.User;
import Handlers.MorphiaHandler;

import java.util.List;

public class OrdersManager {

    MorphiaHandler morphiaHandler;

    public OrdersManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public String insert(Order order) {
        if (order.getProducts().length == 0)
            return "No Products added";
        List<Object> lis = morphiaHandler.getObjById(order.getUserId(), User.class);
        if (lis.size() == 0)
            return "user doesn't exist";
        for (int x : order.getProducts()) {
            List<Object> l = morphiaHandler.getObjById(x, Product.class);
            if (l.size() == 0)
                return "product with id " + x + " doesn't exit";
        }
        morphiaHandler.insert(order);
        return "order added";
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
