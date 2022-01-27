package com.example.dummy;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: userExist.proto")
public final class UserExistServiceGrpc {

  private UserExistServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.dummy.UserExistService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.dummy.UserExist.UserExistRequest,
      com.example.dummy.UserExist.UserExistResponse> getUserExistMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UserExist",
      requestType = com.example.dummy.UserExist.UserExistRequest.class,
      responseType = com.example.dummy.UserExist.UserExistResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.dummy.UserExist.UserExistRequest,
      com.example.dummy.UserExist.UserExistResponse> getUserExistMethod() {
    io.grpc.MethodDescriptor<com.example.dummy.UserExist.UserExistRequest, com.example.dummy.UserExist.UserExistResponse> getUserExistMethod;
    if ((getUserExistMethod = UserExistServiceGrpc.getUserExistMethod) == null) {
      synchronized (UserExistServiceGrpc.class) {
        if ((getUserExistMethod = UserExistServiceGrpc.getUserExistMethod) == null) {
          UserExistServiceGrpc.getUserExistMethod = getUserExistMethod =
              io.grpc.MethodDescriptor.<com.example.dummy.UserExist.UserExistRequest, com.example.dummy.UserExist.UserExistResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UserExist"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.dummy.UserExist.UserExistRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.dummy.UserExist.UserExistResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserExistServiceMethodDescriptorSupplier("UserExist"))
              .build();
        }
      }
    }
    return getUserExistMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserExistServiceStub newStub(io.grpc.Channel channel) {
    return new UserExistServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserExistServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserExistServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserExistServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserExistServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class UserExistServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void userExist(com.example.dummy.UserExist.UserExistRequest request,
        io.grpc.stub.StreamObserver<com.example.dummy.UserExist.UserExistResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getUserExistMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getUserExistMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.dummy.UserExist.UserExistRequest,
                com.example.dummy.UserExist.UserExistResponse>(
                  this, METHODID_USER_EXIST)))
          .build();
    }
  }

  /**
   */
  public static final class UserExistServiceStub extends io.grpc.stub.AbstractStub<UserExistServiceStub> {
    private UserExistServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserExistServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserExistServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserExistServiceStub(channel, callOptions);
    }

    /**
     */
    public void userExist(com.example.dummy.UserExist.UserExistRequest request,
        io.grpc.stub.StreamObserver<com.example.dummy.UserExist.UserExistResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUserExistMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserExistServiceBlockingStub extends io.grpc.stub.AbstractStub<UserExistServiceBlockingStub> {
    private UserExistServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserExistServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserExistServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserExistServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.dummy.UserExist.UserExistResponse userExist(com.example.dummy.UserExist.UserExistRequest request) {
      return blockingUnaryCall(
          getChannel(), getUserExistMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserExistServiceFutureStub extends io.grpc.stub.AbstractStub<UserExistServiceFutureStub> {
    private UserExistServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserExistServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserExistServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserExistServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.dummy.UserExist.UserExistResponse> userExist(
        com.example.dummy.UserExist.UserExistRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUserExistMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_USER_EXIST = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserExistServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserExistServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_USER_EXIST:
          serviceImpl.userExist((com.example.dummy.UserExist.UserExistRequest) request,
              (io.grpc.stub.StreamObserver<com.example.dummy.UserExist.UserExistResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class UserExistServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserExistServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.dummy.UserExist.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserExistService");
    }
  }

  private static final class UserExistServiceFileDescriptorSupplier
      extends UserExistServiceBaseDescriptorSupplier {
    UserExistServiceFileDescriptorSupplier() {}
  }

  private static final class UserExistServiceMethodDescriptorSupplier
      extends UserExistServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserExistServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (UserExistServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserExistServiceFileDescriptorSupplier())
              .addMethod(getUserExistMethod())
              .build();
        }
      }
    }
    return result;
  }
}
