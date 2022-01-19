import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.bson.conversions.Bson;

public class MongoDBManager {

    private MongoClient mongoClient;

    public void connectMongoDB(String host, int port) {
        this.mongoClient = new MongoClient(host, port);
    }

    public MongoIterable<String> getListofDatabases() {
        MongoIterable<String> list = mongoClient.listDatabaseNames();
        return list;
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

    public void insertIntoCollection(String collection, String db, Document doc) {
        getCollection(collection, db).insertOne(doc);
    }

    public FindIterable<Document> findDocsWithQuery(String coll, String db, Document query) {
        FindIterable<Document> iterDoc = getCollection(coll, db).find(query);
        return iterDoc;
    }

    public FindIterable<Document> getAlldocumentsInCollection(String coll, String db) {
        FindIterable<Document> iterDoc = getCollection(coll, db).find();
        return iterDoc;
    }

    public void update(String coll, String db, Bson query, Bson updates) {
        getCollection(coll, db).updateOne(query, updates);
    }

    public void delete(String coll, String db, Bson query) {
        getCollection(coll, db).deleteMany(query);
    }

}
