import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.Iterator;

public class ProductsManager {
    private static MongoDBManager mongoDBManager = new MongoDBManager();
    private static String name;
    private static int price;
    private static int stock;

    public void insert(String name, int price, int stock) {
        Document doc = new Document();
        doc.append("name", name);
        doc.append("price", price);
        doc.append("stock", stock);
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
