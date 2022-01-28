package com.example.dummy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserExistClient {

    UserExistServer userExistServer = new UserExistServer();

    public boolean doesUserExist(int userId) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    userExistServer.server();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();
        UserExistServiceGrpc.UserExistServiceBlockingStub stub = UserExistServiceGrpc.newBlockingStub(channel);
        UserExist.UserExistRequest request =
                UserExist.UserExistRequest.newBuilder()
                        .setUserId(userId)
                        .build();
        UserExist.UserExistResponse response =
                stub.userExist(request);
        channel.shutdownNow();

        return response.getUser();
    }
}
