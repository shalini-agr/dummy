import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.Iterator;

public class ProductsManager {
    MongoDBManager mongoDBManager = new MongoDBManager();

    public ProductsManager() {
        mongoDBManager.connectMongoDB("localhost", 27018);
    }

    public void insert(Product p) {
        Document doc = new Document();
        doc.append("name", p.getName());
        doc.append("price", p.getPrice());
        doc.append("stock", p.getStock());
        mongoDBManager.insertIntoCollection("products", "shop", doc);
    }

    public void printDocumentsByName(String name) {
        FindIterable<Document> iterDoc = mongoDBManager.findDocsWithQuery("products", "shop", new Document().append("name", name));
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void deleteDocByName(String name) {
        mongoDBManager.delete("products", "shop", new Document().append("name", name));
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
