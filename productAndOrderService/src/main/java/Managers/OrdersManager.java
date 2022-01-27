package Managers;

import Entities.Order;

import Handlers.MorphiaHandler;
import com.example.dummy.UserExistClient;
import com.example.dummy.UserExistServer;

import java.util.List;

public class OrdersManager {

    MorphiaHandler morphiaHandler;
    ProductsManager productsManager;
    UserExistClient userExistClient;
    UserExistServer userExistServer;

    public OrdersManager() {
        morphiaHandler = new MorphiaHandler();
        productsManager = new ProductsManager();
        userExistClient = new UserExistClient();
        userExistServer = new UserExistServer();
    }

    public String insert(Order order) {
        if (order.getProducts().length == 0)
            return "No Products added";
        // Starting gRPC Server
        new Thread(new Runnable() {
            public void run() {
                try {
                    userExistServer.server();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        if (!userExistClient.doesUserExist(order.getUserId()))
            return "user doesn't exist";
        for (int x : order.getProducts()) {
            List<Object> l = productsManager.getProductById(x);
            if (l.size() == 0)
                return "product with id " + x + " doesn't exit";
        }
        morphiaHandler.insert(order);
        return "order added";
    }

    public List<Object> getOrders() {
        return morphiaHandler.getAllDocs(Order.class);
    }

    public List<Object> getOrderById(int id) {
        return morphiaHandler.getObjById(id, Order.class);
    }

    public String delete(int id) {
        morphiaHandler.delete(id, Order.class);
        return "order deleted";
    }
}
