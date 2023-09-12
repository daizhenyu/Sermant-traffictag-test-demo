package org.javaboy.grpc.demo;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.51.0)",
    comments = "Source: product.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ProductInfoGrpc {

  private ProductInfoGrpc() {}

  public static final String SERVICE_NAME = "product.ProductInfo";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<Product,
      ProductId> getAddProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProduct",
      requestType = Product.class,
      responseType = ProductId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<Product,
      ProductId> getAddProductMethod() {
    io.grpc.MethodDescriptor<Product, ProductId> getAddProductMethod;
    if ((getAddProductMethod = ProductInfoGrpc.getAddProductMethod) == null) {
      synchronized (ProductInfoGrpc.class) {
        if ((getAddProductMethod = ProductInfoGrpc.getAddProductMethod) == null) {
          ProductInfoGrpc.getAddProductMethod = getAddProductMethod =
              io.grpc.MethodDescriptor.<Product, ProductId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProductId.getDefaultInstance()))
              .setSchemaDescriptor(new ProductInfoMethodDescriptorSupplier("addProduct"))
              .build();
        }
      }
    }
    return getAddProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Product,
      ProductId> getCheckProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "checkProduct",
      requestType = Product.class,
      responseType = ProductId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<Product,
      ProductId> getCheckProductMethod() {
    io.grpc.MethodDescriptor<Product, ProductId> getCheckProductMethod;
    if ((getCheckProductMethod = ProductInfoGrpc.getCheckProductMethod) == null) {
      synchronized (ProductInfoGrpc.class) {
        if ((getCheckProductMethod = ProductInfoGrpc.getCheckProductMethod) == null) {
          ProductInfoGrpc.getCheckProductMethod = getCheckProductMethod =
              io.grpc.MethodDescriptor.<Product, ProductId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "checkProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProductId.getDefaultInstance()))
              .setSchemaDescriptor(new ProductInfoMethodDescriptorSupplier("checkProduct"))
              .build();
        }
      }
    }
    return getCheckProductMethod;
  }

  private static volatile io.grpc.MethodDescriptor<Product,
      ProductId> getAddProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addProducts",
      requestType = Product.class,
      responseType = ProductId.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<Product,
      ProductId> getAddProductsMethod() {
    io.grpc.MethodDescriptor<Product, ProductId> getAddProductsMethod;
    if ((getAddProductsMethod = ProductInfoGrpc.getAddProductsMethod) == null) {
      synchronized (ProductInfoGrpc.class) {
        if ((getAddProductsMethod = ProductInfoGrpc.getAddProductsMethod) == null) {
          ProductInfoGrpc.getAddProductsMethod = getAddProductsMethod =
              io.grpc.MethodDescriptor.<Product, ProductId>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Product.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProductId.getDefaultInstance()))
              .setSchemaDescriptor(new ProductInfoMethodDescriptorSupplier("addProducts"))
              .build();
        }
      }
    }
    return getAddProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ProductId,
      Product> getGetProductsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProducts",
      requestType = ProductId.class,
      responseType = Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<ProductId,
      Product> getGetProductsMethod() {
    io.grpc.MethodDescriptor<ProductId, Product> getGetProductsMethod;
    if ((getGetProductsMethod = ProductInfoGrpc.getGetProductsMethod) == null) {
      synchronized (ProductInfoGrpc.class) {
        if ((getGetProductsMethod = ProductInfoGrpc.getGetProductsMethod) == null) {
          ProductInfoGrpc.getGetProductsMethod = getGetProductsMethod =
              io.grpc.MethodDescriptor.<ProductId, Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProducts"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProductId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Product.getDefaultInstance()))
              .setSchemaDescriptor(new ProductInfoMethodDescriptorSupplier("getProducts"))
              .build();
        }
      }
    }
    return getGetProductsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ProductId,
      Product> getGetProductMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProduct",
      requestType = ProductId.class,
      responseType = Product.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ProductId,
      Product> getGetProductMethod() {
    io.grpc.MethodDescriptor<ProductId, Product> getGetProductMethod;
    if ((getGetProductMethod = ProductInfoGrpc.getGetProductMethod) == null) {
      synchronized (ProductInfoGrpc.class) {
        if ((getGetProductMethod = ProductInfoGrpc.getGetProductMethod) == null) {
          ProductInfoGrpc.getGetProductMethod = getGetProductMethod =
              io.grpc.MethodDescriptor.<ProductId, Product>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProduct"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ProductId.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Product.getDefaultInstance()))
              .setSchemaDescriptor(new ProductInfoMethodDescriptorSupplier("getProduct"))
              .build();
        }
      }
    }
    return getGetProductMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductInfoStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInfoStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductInfoStub>() {
        @Override
        public ProductInfoStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductInfoStub(channel, callOptions);
        }
      };
    return ProductInfoStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductInfoBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInfoBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductInfoBlockingStub>() {
        @Override
        public ProductInfoBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductInfoBlockingStub(channel, callOptions);
        }
      };
    return ProductInfoBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductInfoFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ProductInfoFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ProductInfoFutureStub>() {
        @Override
        public ProductInfoFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ProductInfoFutureStub(channel, callOptions);
        }
      };
    return ProductInfoFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ProductInfoImplBase implements io.grpc.BindableService {

    /**
     */
    public void addProduct(Product request,
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddProductMethod(), responseObserver);
    }

    /**
     */
    public void checkProduct(Product request,
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckProductMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Product> addProducts(
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddProductsMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ProductId> getProducts(
        io.grpc.stub.StreamObserver<Product> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetProductsMethod(), responseObserver);
    }

    /**
     */
    public void getProduct(ProductId request,
        io.grpc.stub.StreamObserver<Product> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                Product,
                ProductId>(
                  this, METHODID_ADD_PRODUCT)))
          .addMethod(
            getCheckProductMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                Product,
                ProductId>(
                  this, METHODID_CHECK_PRODUCT)))
          .addMethod(
            getAddProductsMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                Product,
                ProductId>(
                  this, METHODID_ADD_PRODUCTS)))
          .addMethod(
            getGetProductsMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                ProductId,
                Product>(
                  this, METHODID_GET_PRODUCTS)))
          .addMethod(
            getGetProductMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                ProductId,
                Product>(
                  this, METHODID_GET_PRODUCT)))
          .build();
    }
  }

  /**
   */
  public static final class ProductInfoStub extends io.grpc.stub.AbstractAsyncStub<ProductInfoStub> {
    private ProductInfoStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProductInfoStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInfoStub(channel, callOptions);
    }

    /**
     */
    public void addProduct(Product request,
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void checkProduct(Product request,
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getCheckProductMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<Product> addProducts(
        io.grpc.stub.StreamObserver<ProductId> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddProductsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<ProductId> getProducts(
        io.grpc.stub.StreamObserver<Product> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGetProductsMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void getProduct(ProductId request,
        io.grpc.stub.StreamObserver<Product> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ProductInfoBlockingStub extends io.grpc.stub.AbstractBlockingStub<ProductInfoBlockingStub> {
    private ProductInfoBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProductInfoBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInfoBlockingStub(channel, callOptions);
    }

    /**
     */
    public ProductId addProduct(Product request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<ProductId> checkProduct(
        Product request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getCheckProductMethod(), getCallOptions(), request);
    }

    /**
     */
    public Product getProduct(ProductId request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetProductMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ProductInfoFutureStub extends io.grpc.stub.AbstractFutureStub<ProductInfoFutureStub> {
    private ProductInfoFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected ProductInfoFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ProductInfoFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<ProductId> addProduct(
        Product request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddProductMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Product> getProduct(
        ProductId request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetProductMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_PRODUCT = 0;
  private static final int METHODID_CHECK_PRODUCT = 1;
  private static final int METHODID_GET_PRODUCT = 2;
  private static final int METHODID_ADD_PRODUCTS = 3;
  private static final int METHODID_GET_PRODUCTS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductInfoImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductInfoImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCT:
          serviceImpl.addProduct((Product) request,
              (io.grpc.stub.StreamObserver<ProductId>) responseObserver);
          break;
        case METHODID_CHECK_PRODUCT:
          serviceImpl.checkProduct((Product) request,
              (io.grpc.stub.StreamObserver<ProductId>) responseObserver);
          break;
        case METHODID_GET_PRODUCT:
          serviceImpl.getProduct((ProductId) request,
              (io.grpc.stub.StreamObserver<Product>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_PRODUCTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addProducts(
              (io.grpc.stub.StreamObserver<ProductId>) responseObserver);
        case METHODID_GET_PRODUCTS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getProducts(
              (io.grpc.stub.StreamObserver<Product>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductInfoBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ProductProto.getDescriptor();
    }

    @Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductInfo");
    }
  }

  private static final class ProductInfoFileDescriptorSupplier
      extends ProductInfoBaseDescriptorSupplier {
    ProductInfoFileDescriptorSupplier() {}
  }

  private static final class ProductInfoMethodDescriptorSupplier
      extends ProductInfoBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductInfoMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ProductInfoGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductInfoFileDescriptorSupplier())
              .addMethod(getAddProductMethod())
              .addMethod(getCheckProductMethod())
              .addMethod(getAddProductsMethod())
              .addMethod(getGetProductsMethod())
              .addMethod(getGetProductMethod())
              .build();
        }
      }
    }
    return result;
  }
}
