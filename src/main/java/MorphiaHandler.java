import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

public class MorphiaHandler {
    Datastore datastore;

    public MorphiaHandler() {
        datastore = new Morphia().createDatastore(new MongoClient("localhost", 27018), "shop");
    }

    public String insertProduct(Product product) {
        datastore.save(product);
        return "product added";
    }

    public String insertUser(User user) {
        datastore.save(user);
        return "user added";
    }

    public String insertOrder(Order order) {
        List<User> q = datastore.find(User.class, "id", order.getUserId()).asList();
        if (q.size() == 0)
            return "user doesn't exist";
        for (int x : order.getProducts()) {
            List<Product> l = datastore.find(Product.class, "id", x).asList();
            if (l.size() == 0)
                return "product with id " + x + " doesn't exit";
        }
        datastore.save(order);
        return "order added";
    }

    public List<User> getUsers() {
        Query<User> q = datastore.find(User.class);
        return q.asList();
    }

    public List<Order> getOrders() {
        Query<Order> q = datastore.find(Order.class);
        return q.asList();
    }

    public List<Product> getProducts() {
        Query<Product> q = datastore.find(Product.class);
        return q.asList();
    }

    public List<User> getUserById(int id) {
        Query<User> q = datastore.find(User.class, "id", id);
        return q.asList();
    }

    public List<Product> getProductById(int id) {
        Query<Product> q = datastore.find(Product.class, "id", id);
        List<Product> ll = q.asList();
        return ll;
    }

    public List<Order> getOrderById(int id) {
        Query<Order> q = datastore.find(Order.class, "id", id);
        return q.asList();
    }

    public List<Order> getOrdersOfUser(int id) {
        Query<Order> q = datastore.find(Order.class, "userId", id);
        return q.asList();
    }

    public void deleteUserById(int id) {
        datastore.delete(User.class, id);
    }

    public void deleteOrderById(int id) {
        datastore.delete(Order.class, id);
    }

    public void deleteProductById(int id) {
        datastore.delete(Product.class, id);
    }

    public String updateProductPrice(int id, int price) {
        Query query = datastore.createQuery(Product.class).field("id").equal(id);
        UpdateOperations<Product> ops = datastore.createUpdateOperations(Product.class).set("price", price);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateProductStock(int id, int stock) {
        Query query = datastore.createQuery(Product.class).field("id").equal(id);
        UpdateOperations<Product> ops = datastore.createUpdateOperations(Product.class).set("stock", stock);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateUserName(int id, String name) {
        Query query = datastore.createQuery(User.class).field("id").equal(id);
        UpdateOperations<User> ops = datastore.createUpdateOperations(User.class).set("name", name);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateUserPhoneNo(int id, String phoneNo) {
        Query query = datastore.createQuery(User.class).field("id").equal(id);
        UpdateOperations<User> ops = datastore.createUpdateOperations(User.class).set("phoneNo", phoneNo);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateUserEmail(int id, String email) {
        Query query = datastore.createQuery(User.class).field("id").equal(id);
        UpdateOperations<User> ops = datastore.createUpdateOperations(User.class).set("email", email);
        datastore.update(query, ops);
        return "update Successful";
    }

}
