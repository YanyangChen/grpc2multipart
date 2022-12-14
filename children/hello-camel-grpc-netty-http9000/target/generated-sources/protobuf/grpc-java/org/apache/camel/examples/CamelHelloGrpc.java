package org.apache.camel.examples;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The camel hello service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: hellocamel.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CamelHelloGrpc {

  private CamelHelloGrpc() {}

  public static final String SERVICE_NAME = "org.apache.camel.examples.CamelHello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.camel.examples.CamelHelloRequest,
      org.apache.camel.examples.CamelHelloReply> getSayHelloToCamelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHelloToCamel",
      requestType = org.apache.camel.examples.CamelHelloRequest.class,
      responseType = org.apache.camel.examples.CamelHelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.camel.examples.CamelHelloRequest,
      org.apache.camel.examples.CamelHelloReply> getSayHelloToCamelMethod() {
    io.grpc.MethodDescriptor<org.apache.camel.examples.CamelHelloRequest, org.apache.camel.examples.CamelHelloReply> getSayHelloToCamelMethod;
    if ((getSayHelloToCamelMethod = CamelHelloGrpc.getSayHelloToCamelMethod) == null) {
      synchronized (CamelHelloGrpc.class) {
        if ((getSayHelloToCamelMethod = CamelHelloGrpc.getSayHelloToCamelMethod) == null) {
          CamelHelloGrpc.getSayHelloToCamelMethod = getSayHelloToCamelMethod =
              io.grpc.MethodDescriptor.<org.apache.camel.examples.CamelHelloRequest, org.apache.camel.examples.CamelHelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHelloToCamel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.camel.examples.CamelHelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.camel.examples.CamelHelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new CamelHelloMethodDescriptorSupplier("SayHelloToCamel"))
              .build();
        }
      }
    }
    return getSayHelloToCamelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CamelHelloStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CamelHelloStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CamelHelloStub>() {
        @java.lang.Override
        public CamelHelloStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CamelHelloStub(channel, callOptions);
        }
      };
    return CamelHelloStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CamelHelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CamelHelloBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CamelHelloBlockingStub>() {
        @java.lang.Override
        public CamelHelloBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CamelHelloBlockingStub(channel, callOptions);
        }
      };
    return CamelHelloBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CamelHelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CamelHelloFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CamelHelloFutureStub>() {
        @java.lang.Override
        public CamelHelloFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CamelHelloFutureStub(channel, callOptions);
        }
      };
    return CamelHelloFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static abstract class CamelHelloImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHelloToCamel(org.apache.camel.examples.CamelHelloRequest request,
        io.grpc.stub.StreamObserver<org.apache.camel.examples.CamelHelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloToCamelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloToCamelMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.apache.camel.examples.CamelHelloRequest,
                org.apache.camel.examples.CamelHelloReply>(
                  this, METHODID_SAY_HELLO_TO_CAMEL)))
          .build();
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class CamelHelloStub extends io.grpc.stub.AbstractAsyncStub<CamelHelloStub> {
    private CamelHelloStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamelHelloStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CamelHelloStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHelloToCamel(org.apache.camel.examples.CamelHelloRequest request,
        io.grpc.stub.StreamObserver<org.apache.camel.examples.CamelHelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloToCamelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class CamelHelloBlockingStub extends io.grpc.stub.AbstractBlockingStub<CamelHelloBlockingStub> {
    private CamelHelloBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamelHelloBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CamelHelloBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public org.apache.camel.examples.CamelHelloReply sayHelloToCamel(org.apache.camel.examples.CamelHelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloToCamelMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class CamelHelloFutureStub extends io.grpc.stub.AbstractFutureStub<CamelHelloFutureStub> {
    private CamelHelloFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CamelHelloFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CamelHelloFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.camel.examples.CamelHelloReply> sayHelloToCamel(
        org.apache.camel.examples.CamelHelloRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloToCamelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO_TO_CAMEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CamelHelloImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CamelHelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_TO_CAMEL:
          serviceImpl.sayHelloToCamel((org.apache.camel.examples.CamelHelloRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.camel.examples.CamelHelloReply>) responseObserver);
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

  private static abstract class CamelHelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CamelHelloBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.camel.examples.HelloCamelProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CamelHello");
    }
  }

  private static final class CamelHelloFileDescriptorSupplier
      extends CamelHelloBaseDescriptorSupplier {
    CamelHelloFileDescriptorSupplier() {}
  }

  private static final class CamelHelloMethodDescriptorSupplier
      extends CamelHelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CamelHelloMethodDescriptorSupplier(String methodName) {
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
      synchronized (CamelHelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CamelHelloFileDescriptorSupplier())
              .addMethod(getSayHelloToCamelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
