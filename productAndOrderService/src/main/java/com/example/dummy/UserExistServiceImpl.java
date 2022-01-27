package com.example.dummy;

import Managers.UsersManager;
import io.grpc.stub.StreamObserver;

import java.util.List;

public class UserExistServiceImpl extends UserExistServiceGrpc.UserExistServiceImplBase {
    @Override
    public void userExist(UserExist.UserExistRequest request,
                         StreamObserver<UserExist.UserExistResponse> responseObserver) {

        UsersManager usersManager = new UsersManager();
        List<Object> lis = usersManager.getUserById(request.getUserId());
        boolean user = true;
        if(lis.size()==0)
            user = false;

        UserExist.UserExistResponse response = UserExist.UserExistResponse.newBuilder()
                .setUser(user)
                .build();

        responseObserver.onNext(response);

        responseObserver.onCompleted();
    }
}