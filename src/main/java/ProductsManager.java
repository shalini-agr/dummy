import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager {
    MongoDBManager mongoDBManager;
    Gson gson;

    public ProductsManager() {
        mongoDBManager = new MongoDBManager();
        mongoDBManager.connectMongoDB("localhost", 27018);
        gson = new Gson();
    }

    public String insert(Product p) {
        final String asJson = gson.toJson(p);
        final Document doc = Document.parse(asJson);
        mongoDBManager.insertIntoCollection("products", "shop", doc);
        return "product added";
    }

    public List<Product> getProductByName(String name) {
        FindIterable<Document> iterDoc = mongoDBManager.findDocsWithQuery("products", "shop", new Document().append("name", name));
        List<Product> list = new ArrayList<Product>();
        for (Document document : iterDoc) {
            Product p = new Product((String) document.get("name"), (Integer) document.get("price"), (Integer) document.get("stock"));
            list.add(p);
        }
        return list;
    }

    public String deleteProductByName(String name) {
        mongoDBManager.delete("products", "shop", new Document().append("name", name));
        return "product deleted";
    }

    public void updatePrice(String name, int price) {
        mongoDBManager.update("products", "shop", new Document().append("name", name), new Document().append("$set", new Document().append("price", price)));
    }

    public void updateStock(String name, int stock) {
        mongoDBManager.update("products", "shop", new Document().append("name", name), new Document().append("$set", new Document().append("stock", stock)));
    }

    public void updatePriceAndStock(String name, int stock, int price) {
        mongoDBManager.update("products", "shop", new Document().append("name", name), new Document().append("$set", new Document().append("stock", stock)).append("$set", new Document().append("price", price)));
    }

}
