package Entities;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("order")
public class Order {
    @Id
    int id;
    int userId;
    int[] products;
    String date;

    public Order(int id, int userId, int[] products, String date) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.date = date;
    }

    public Order() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getProducts() {
        return products;
    }

    public void setProducts(int[] products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
