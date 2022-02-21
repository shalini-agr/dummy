import java.io.IOException;

public class DebeziumApp {
    public static void main(String[] args) throws IOException {
        DebeziumListener debeziumListener = new DebeziumListener(new DebeziumConfig().customerConnector());
        debeziumListener.start();
    }
}
