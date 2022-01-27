package com.example.dummy;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UserExistClient {

    public boolean doesUserExist(int userId) {
        final ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext(true)
                .build();
        UserExistServiceGrpc.UserExistServiceBlockingStub stub = UserExistServiceGrpc.newBlockingStub(channel);
        UserExist.UserExistRequest request =
                UserExist.UserExistRequest.newBuilder()
                        .setUserId(userId)
                        .build();
        System.out.println(request.getUserId());
        UserExist.UserExistResponse response =
                stub.userExist(request);
        channel.shutdownNow();
        System.out.println(response.getUser());

        return response.getUser();
    }
}