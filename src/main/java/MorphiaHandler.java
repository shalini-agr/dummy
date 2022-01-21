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

    public String insert(Product product) {
        datastore.save(product);
        return "product added";
    }

    public List<Product> getProductByName(String name) {
        Query<Product> q = datastore.find(Product.class, "name", name);
        List<Product> ll = q.asList();
        return ll;
    }

    public void deleteByName(String name) {
        datastore.delete(Product.class, name);
    }

    public String updatePrice(String name, int price) {
        Query query = datastore.createQuery(Product.class).field("name").equal(name);
        UpdateOperations<Product> ops = datastore.createUpdateOperations(Product.class).set("price", price);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateStock(String name, int stock) {
        Query query = datastore.createQuery(Product.class).field("name").equal(name);
        UpdateOperations<Product> ops = datastore.createUpdateOperations(Product.class).set("stock", stock);
        datastore.update(query, ops);
        return "update Successful";
    }

    public String updateStockAndPrice(String name, int stock, int price) {
        Query query = datastore.createQuery(Product.class).field("name").equal(name);
        UpdateOperations<Product> ops = datastore.createUpdateOperations(Product.class).set("stock", stock).set("price", price);
        datastore.update(query, ops);
        return "update Successful";
    }


}
