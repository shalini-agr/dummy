package Handlers;

import Entities.Order;
import Entities.Product;
import Entities.User;
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

    public String insert(Object obj) {
        if (obj instanceof Order) {
            Order order = (Order) obj;
            List<User> q = datastore.find(User.class, "id", order.getUserId()).asList();
            if (q.size() == 0)
                return "user doesn't exist";
            for (int x : order.getProducts()) {
                List<Product> l = datastore.find(Product.class, "id", x).asList();
                if (l.size() == 0)
                    return "product with id " + x + " doesn't exit";
            }
            datastore.save(order);
        }
        datastore.save(obj);
        return "object added";
    }

    public List<Object> getAllDocs(Class var1) {
        Query<Object> q = datastore.find(var1);
        return q.asList();
    }

    public List<Object> getObjById(int id, Class var1) {
        Query<Object> q = datastore.find(var1, "id", id);
        return q.asList();
    }

    public List<Order> getOrdersOfUser(int id) {
        Query<Order> q = datastore.find(Order.class, "userId", id);
        return q.asList();
    }

    public void delete(int id, Class var) {
        datastore.delete(var, id);
    }

    public String updateProduct(int id, String key, Object val) {
        Query query = datastore.createQuery(Product.class).field("id").equal(id);
        UpdateOperations<Product> ops;
        if (val instanceof String)
            ops = datastore.createUpdateOperations(Product.class).set(key, (String) val);
        else
            ops = datastore.createUpdateOperations(Product.class).set(key, (Integer) val);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateUser(int id, String key, String val) {
        Query query = datastore.createQuery(User.class).field("id").equal(id);
        UpdateOperations<User> ops = datastore.createUpdateOperations(User.class).set(key, val);
        datastore.update(query, ops);
        return "update Successful";
    }

}
