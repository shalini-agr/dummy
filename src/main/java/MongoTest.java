import com.mongodb.*;

import java.util.Date;

public class MongoTest {

    public static void main(String [] args)
    {
        System.out.println("Hello World!");
        connectDB();
    }

    private static void connectDB() {
        MongoClient mongoClient= new MongoClient("localhost", 27017);
        mongoClient.getDatabaseNames().forEach(System.out::println);

        DB db = (DB) mongoClient.getDB("test");
        DBCollection myCol = db.getCollection("myCollection");
        BasicDBObject document = new BasicDBObject();
        document.put("videoname", "Blade Runner");
        document.put("Actor", "Harrison Ford");
        document.put("Actor2", ""); document.put("Released", "1982"); document.put("createdDate", new Date());
        myCol.insert(document);

        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("videoname", "Blade Runner");

        DBCursor cursor = myCol.find(searchQuery);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("Actor2", "Rutger Hauer");
        myCol.update(searchQuery, newDocument);

        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
