import io.debezium.config.Configuration;
import io.debezium.embedded.Connect;
import io.debezium.engine.ChangeEvent;
import io.debezium.engine.DebeziumEngine;
import io.debezium.engine.RecordChangeEvent;
import io.debezium.engine.format.ChangeEventFormat;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.kafka.clients.admin.AlterConfigOp;
import org.apache.kafka.connect.data.Field;
import org.apache.kafka.connect.data.Struct;
import org.apache.kafka.connect.source.SourceRecord;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import io.debezium.engine.format.Json;

import static io.debezium.data.Envelope.FieldName.*;
import static io.debezium.data.Envelope.Operation;
import static java.util.stream.Collectors.toMap;

public class DebeziumListener {

    private final Executor executor = Executors.newSingleThreadExecutor();
    private final DebeziumEngine<ChangeEvent<String, String>> debeziumEngine;
    public DebeziumListener(Configuration customerConnectorConfiguration) {
        this.debeziumEngine = DebeziumEngine.create(Json.class).using(customerConnectorConfiguration.asProperties()).notifying(record -> {
            System.out.println(record);
        }).build();
    }
//        this.debeziumEngine = DebeziumEngine.create(ChangeEventFormat.of(Connect.class))
//                .using(customerConnectorConfiguration.asProperties())
//                .notifying(this::handleChangeEvent)
//                .build();    }

    private void handleChangeEvent(RecordChangeEvent<SourceRecord> sourceRecordRecordChangeEvent) {
        SourceRecord sourceRecord = sourceRecordRecordChangeEvent.record();
        Struct sourceRecordChangeValue = (Struct) sourceRecord.value();
        if (sourceRecordChangeValue != null) {
            System.out.println(sourceRecordChangeValue);
            //            if (sourceRecordChangeValue.get(OPERATION) == null) {
//                Operation operation = Operation.forCode((String) sourceRecordChangeValue.get(OPERATION));
//
//            if(operation != Operation.READ) {
//                String record = operation == Operation.DELETE ? BEFORE : AFTER; // Handling Update & Insert operations.
//
//                Struct struct = (Struct) sourceRecordChangeValue.get(record);
//                Map<String, Object> payload = struct.schema().fields().stream()
//                        .map(Field::name)
//                        .filter(fieldName -> struct.get(fieldName) != null)
//                        .map(fieldName -> Pair.of(fieldName, struct.get(fieldName)))
//                        .collect(toMap(Pair::getKey, Pair::getValue));
//                System.out.println(operation.name());
//            }
            }
        }

    public void start() {

        this.executor.execute(debeziumEngine);
    }

    public void stop() throws IOException {
        this.debeziumEngine.close();
    }

}