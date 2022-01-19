import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MainApplication {
    private static MongoDBManager mongoDBManager = new MongoDBManager();

    public static void main(String[] args) {
        mongoDBManager.connectMongoDB("localhost", 27018);
        MongoDatabase shop = mongoDBManager.getDB("shop");
        MongoCollection products = mongoDBManager.getCollection("products", "shop");
        System.out.println("List of Databases:");
        mongoDBManager.printListofDatabases();
        System.out.println("List of Collections in shop:");
        mongoDBManager.printListofCollections("shop");
        Document doc = new Document();
        doc.append("name","pen");
        doc.append("price",10);
        doc.append("stock",20);
        mongoDBManager.insertIntoCollection(products,doc);
        Document doc1 = new Document();
        doc.append("name","pencil");
        doc.append("price",5);
        doc.append("stock",25);
        mongoDBManager.insertIntoCollection(products,doc1);
        System.out.println("List of Documents in products:");
        mongoDBManager.printAlldocumentsInCollection(products);
        Document query = new Document().append("name","pen");
        Document update = new Document().append("$set",new Document().append("price",20));
        mongoDBManager.update(products,query,update);
        System.out.println("List of Documents in products after update:");
        mongoDBManager.printAlldocumentsInCollection(products);
        mongoDBManager.delete(products,query);
        System.out.println("List of Documents in products after deletion:");
        mongoDBManager.printAlldocumentsInCollection(products);
    }

}
