package currencyservice;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.logging.Logger;

import static bank.Bank.PORT;

public class CurrencyServer {

    private Server server;

    private void start() throws IOException {
        server = ServerBuilder.forPort(PORT)
                .addService(new CurrencyServiceImpl())
                .build()
                .start();
        System.out.println("Server started on " + PORT);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            CurrencyServer.this.stop();
            System.err.println("*** server shut down");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final CurrencyServer server = new CurrencyServer();
        server.start();
        server.blockUntilShutdown();
    }
}
