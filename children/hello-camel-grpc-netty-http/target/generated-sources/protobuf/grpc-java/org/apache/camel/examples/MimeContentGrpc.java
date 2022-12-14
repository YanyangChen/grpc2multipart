package org.apache.camel.examples;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * The camel hello service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.45.0)",
    comments = "Source: mimeContent.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MimeContentGrpc {

  private MimeContentGrpc() {}

  public static final String SERVICE_NAME = "org.apache.camel.examples.MimeContent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<org.apache.camel.examples.MimeContentRequest,
      org.apache.camel.examples.MimeContentReply> getSayHelloMimeContentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHelloMimeContent",
      requestType = org.apache.camel.examples.MimeContentRequest.class,
      responseType = org.apache.camel.examples.MimeContentReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<org.apache.camel.examples.MimeContentRequest,
      org.apache.camel.examples.MimeContentReply> getSayHelloMimeContentMethod() {
    io.grpc.MethodDescriptor<org.apache.camel.examples.MimeContentRequest, org.apache.camel.examples.MimeContentReply> getSayHelloMimeContentMethod;
    if ((getSayHelloMimeContentMethod = MimeContentGrpc.getSayHelloMimeContentMethod) == null) {
      synchronized (MimeContentGrpc.class) {
        if ((getSayHelloMimeContentMethod = MimeContentGrpc.getSayHelloMimeContentMethod) == null) {
          MimeContentGrpc.getSayHelloMimeContentMethod = getSayHelloMimeContentMethod =
              io.grpc.MethodDescriptor.<org.apache.camel.examples.MimeContentRequest, org.apache.camel.examples.MimeContentReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHelloMimeContent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.camel.examples.MimeContentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  org.apache.camel.examples.MimeContentReply.getDefaultInstance()))
              .setSchemaDescriptor(new MimeContentMethodDescriptorSupplier("SayHelloMimeContent"))
              .build();
        }
      }
    }
    return getSayHelloMimeContentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MimeContentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MimeContentStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MimeContentStub>() {
        @java.lang.Override
        public MimeContentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MimeContentStub(channel, callOptions);
        }
      };
    return MimeContentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MimeContentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MimeContentBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MimeContentBlockingStub>() {
        @java.lang.Override
        public MimeContentBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MimeContentBlockingStub(channel, callOptions);
        }
      };
    return MimeContentBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MimeContentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MimeContentFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MimeContentFutureStub>() {
        @java.lang.Override
        public MimeContentFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MimeContentFutureStub(channel, callOptions);
        }
      };
    return MimeContentFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static abstract class MimeContentImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHelloMimeContent(org.apache.camel.examples.MimeContentRequest request,
        io.grpc.stub.StreamObserver<org.apache.camel.examples.MimeContentReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMimeContentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMimeContentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                org.apache.camel.examples.MimeContentRequest,
                org.apache.camel.examples.MimeContentReply>(
                  this, METHODID_SAY_HELLO_MIME_CONTENT)))
          .build();
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class MimeContentStub extends io.grpc.stub.AbstractAsyncStub<MimeContentStub> {
    private MimeContentStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MimeContentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MimeContentStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public void sayHelloMimeContent(org.apache.camel.examples.MimeContentRequest request,
        io.grpc.stub.StreamObserver<org.apache.camel.examples.MimeContentReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMimeContentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class MimeContentBlockingStub extends io.grpc.stub.AbstractBlockingStub<MimeContentBlockingStub> {
    private MimeContentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MimeContentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MimeContentBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public org.apache.camel.examples.MimeContentReply sayHelloMimeContent(org.apache.camel.examples.MimeContentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMimeContentMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The camel hello service definition.
   * </pre>
   */
  public static final class MimeContentFutureStub extends io.grpc.stub.AbstractFutureStub<MimeContentFutureStub> {
    private MimeContentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MimeContentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MimeContentFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Sends a greeting
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<org.apache.camel.examples.MimeContentReply> sayHelloMimeContent(
        org.apache.camel.examples.MimeContentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMimeContentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO_MIME_CONTENT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MimeContentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MimeContentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO_MIME_CONTENT:
          serviceImpl.sayHelloMimeContent((org.apache.camel.examples.MimeContentRequest) request,
              (io.grpc.stub.StreamObserver<org.apache.camel.examples.MimeContentReply>) responseObserver);
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

  private static abstract class MimeContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MimeContentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return org.apache.camel.examples.MimeContentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MimeContent");
    }
  }

  private static final class MimeContentFileDescriptorSupplier
      extends MimeContentBaseDescriptorSupplier {
    MimeContentFileDescriptorSupplier() {}
  }

  private static final class MimeContentMethodDescriptorSupplier
      extends MimeContentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MimeContentMethodDescriptorSupplier(String methodName) {
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
      synchronized (MimeContentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MimeContentFileDescriptorSupplier())
              .addMethod(getSayHelloMimeContentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
