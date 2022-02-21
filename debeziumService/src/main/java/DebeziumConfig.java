import java.io.File;
import java.io.IOException;

public class DebeziumConfig {
    public io.debezium.config.Configuration customerConnector() throws IOException {
        File offsetStorageTempFile = File.createTempFile("offsets_", ".dat");
        File dbHistoryTempFile = File.createTempFile("dbhistory_", ".dat");
        return io.debezium.config.Configuration.create()
                .with("name", "dummy-mongodb-connector")
                .with("connector.class", "io.debezium.connector.mongodb.MongoDbConnector")
                .with("offset.storage", "org.apache.kafka.connect.storage.FileOffsetBackingStore")
                .with("offset.storage.file.filename", offsetStorageTempFile.getAbsolutePath())
                .with("database.history", "io.debezium.relational.history.FileDatabaseHistory")
                .with("database.history.file.filename", dbHistoryTempFile.getAbsolutePath())
                .with("offset.flush.interval.ms", 120000)
                .with("converter.schemas.enable", "false")
                .with("mongodb.name", "shop_db")
                .with("mongodb.hosts", "rs0/localhost:27017")
                .with("mongodb.user","")
                .with("mongodb.password","")
                .with("database.include.list","shop")
                .with("collection.include.list","product")
//                .with("connector.class","io.debezium.connector.mysql.MySqlConnector")
//                .with("database.user", "root")
//                .with("database.password", "Mysql@pw")
//                .with("database.hostname", "localhost")
//                .with("database.port", 3306)
//                .with("database.server.id", 1)
//                .with("database.server.name", "products")
//                .with("database.include.list", "shop")
                .build();
    }
}