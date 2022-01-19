import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Iterator;


public class MongoDBManager {

    private static MongoClient mongoClient;

    public void connectMongoDB(String host, int port) {
        this.mongoClient = new MongoClient(host, port);
    }

    public MongoIterable<String> getListofDatabases() {
        MongoIterable<String> list = mongoClient.listDatabaseNames();
        return list;
    }

    public void printListofDatabases() {
        MongoIterable<String> list = getListofDatabases();
        for (String name : list) {
            System.out.println(name);
        }
    }

    public MongoDatabase getDB(String dbName) {
        MongoDatabase db = mongoClient.getDatabase(dbName);
        return db;
    }

    public MongoCollection getCollection(String collection, String dbName) {
        MongoCollection myCollection = getDB(dbName).getCollection(collection);
        return myCollection;
    }

    public MongoIterable<String> getListofCollections(String dbName) {
        MongoIterable<String> list = getDB(dbName).listCollectionNames();
        return list;
    }

    public void printListofCollections(String dbName) {
        MongoIterable<String> list = getListofCollections(dbName);
        for (String name : list) {
            System.out.println(name);
        }
    }

    public void insertIntoCollection(MongoCollection coll, Document doc) {
        coll.insertOne(doc);
    }

    public void printAlldocumentsInCollection(MongoCollection coll)
    {
        FindIterable<Document> iterDoc = coll.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void update(MongoCollection coll, Bson query, Bson updates){
        coll.updateOne(query,updates);
    }

    public void delete(MongoCollection coll,Bson query)
    {
        coll.deleteMany(query);
    }

}
