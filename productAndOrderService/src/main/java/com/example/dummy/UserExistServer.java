package com.example.dummy;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

public class UserExistServer {

    public void server() throws Exception{
        Server server = ServerBuilder.forPort(8080)
                .addService((BindableService) new UserExistServiceImpl())
                .build();

        server.start();

        server.awaitTermination();
    }
}
