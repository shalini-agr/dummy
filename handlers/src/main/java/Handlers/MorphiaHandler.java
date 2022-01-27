package Handlers;

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

    public void insert(Object obj) {
        datastore.save(obj);
    }

    public List<Object> getAllDocs(Class var1) {
        Query<Object> q = datastore.find(var1);
        return q.asList();
    }

    public List<Object> getObjById(int id, Class var1) {
        Query<Object> q = datastore.find(var1, "id", id);
        return q.asList();
    }

    public void delete(int id, Class var) {
        datastore.delete(var, id);
    }

    public String update(int id, String key, Object val, Class var) {
        Object query = datastore.createQuery(var).field("id").equal(id);
        UpdateOperations<Object> ops;
        if (val instanceof String)
            ops = datastore.createUpdateOperations(var).set(key, (String) val);
        else
            ops = datastore.createUpdateOperations(var).set(key, (Integer) val);
        datastore.update(query, ops);
        return "update Successful";
    }

}
