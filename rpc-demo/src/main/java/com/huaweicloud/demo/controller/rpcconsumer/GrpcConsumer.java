/*
 *  Copyright (C) 2023-2023 Huawei Technologies Co., Ltd. All rights reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.huaweicloud.demo.controller.rpcconsumer;

import com.google.protobuf.Descriptors;
import com.google.protobuf.DynamicMessage;

import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.ClientCalls;
import io.grpc.stub.StreamObserver;

import com.huaweicloud.demo.grpc.Product;
import com.huaweicloud.demo.grpc.ProductId;
import com.huaweicloud.demo.grpc.ProductInfoGrpc;
import com.huaweicloud.demo.grpc.ProductProto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author daizhenyu
 * @since 2023-09-08
 **/
@RestController
@RequestMapping("grpc")
public class GrpcConsumer {
    @Value("${inner.grpc.server.port}")
    int innerPort;

    @Value("${outer.grpc.server.port}")
    int outerPort;

    @RequestMapping(value="innerstub", method= RequestMethod.GET)
    @ResponseBody
    public String newProduct() {
        ManagedChannel originChannel = ManagedChannelBuilder.forAddress("localhost", 50001)
                .usePlaintext()
                .build();
        ProductInfoGrpc.ProductInfoBlockingStub stub = ProductInfoGrpc.newBlockingStub(originChannel);
        Product p = Product.newBuilder().setId("1")
                .setPrice(688.0f)
                .setName("grpc")
                .setDescription("test")
                .build();
        ProductId productId = stub.addProduct(p);
        originChannel.shutdown();
        return "grpc-stub";
    }

    @RequestMapping(value="innernostub", method= RequestMethod.GET)
    @ResponseBody
    public String noStub() throws ExecutionException, InterruptedException {
        String serverAddress = "localhost";
        String serviceName = "ProductInfo"; // 服务名称，格式为 "package.ServiceName"

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, 50001).usePlaintext().build();

        // 构建服务存根
        //        Descriptors.FileDescriptor serviceFileDescriptor = getServiceFileDescriptor();
        Descriptors.FileDescriptor serviceFileDescriptor = ProductProto.getDescriptor().getFile();
        Descriptors.ServiceDescriptor serviceDescriptor = serviceFileDescriptor.findServiceByName(serviceName);
        Descriptors.MethodDescriptor originMethodDescriptor = serviceDescriptor.getMethods().get(0);
        MethodDescriptor<DynamicMessage, DynamicMessage> methodDescriptor = generateMethodDescriptor(
                originMethodDescriptor);

        // 创建动态消息
        DynamicMessage.Builder requestBuilder = DynamicMessage.newBuilder(originMethodDescriptor.getInputType());
        requestBuilder.setField(originMethodDescriptor.getInputType().findFieldByName("id"), "1");

        DynamicMessage request = requestBuilder.build();

        // 使用 CompletableFuture 处理异步响应
        CallOptions callOptions = CallOptions.DEFAULT;
        CompletableFuture<DynamicMessage> responseFuture = new CompletableFuture<>();
        ClientCalls.asyncUnaryCall(channel.newCall(methodDescriptor, callOptions), request,
                new StreamObserver<DynamicMessage>() {
                    @Override
                    public void onNext(DynamicMessage value) {
                        responseFuture.complete(value);
                    }

                    @Override
                    public void onError(Throwable t) {
                        responseFuture.completeExceptionally(t);
                    }

                    @Override
                    public void onCompleted() {
                        // Do nothing
                    }
                });

        // 等待异步响应完成
        DynamicMessage response = responseFuture.get();
        System.out.println("Response: " + response);
        channel.shutdown();
        return "grpc-nostub";
    }

    @RequestMapping(value="outerstub", method= RequestMethod.GET)
    @ResponseBody
    public String newOuterProduct() {
        ManagedChannel originChannel = ManagedChannelBuilder.forAddress("localhost", 50002)
                .usePlaintext()
                .build();
        ProductInfoGrpc.ProductInfoBlockingStub stub = ProductInfoGrpc.newBlockingStub(originChannel);
        Product p = Product.newBuilder().setId("1")
                .setPrice(688f)
                .setName("grpc")
                .setDescription("test")
                .build();
        ProductId productId = stub.addProduct(p);
        System.out.println(productId.toString());
        originChannel.shutdown();
        return "grpc-stub";
    }

    @RequestMapping(value="outernostub", method= RequestMethod.GET)
    @ResponseBody
    public String noOuterStub() throws ExecutionException, InterruptedException {
        String serverAddress = "localhost";
        String serviceName = "ProductInfo";

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, 50002).usePlaintext().build();

        // 构建服务存根
        Descriptors.FileDescriptor serviceFileDescriptor = ProductProto.getDescriptor().getFile();
        Descriptors.ServiceDescriptor serviceDescriptor = serviceFileDescriptor.findServiceByName(serviceName);
        Descriptors.MethodDescriptor originMethodDescriptor = serviceDescriptor.getMethods().get(0);
        MethodDescriptor<DynamicMessage, DynamicMessage> methodDescriptor = generateMethodDescriptor(
                originMethodDescriptor);

        // 创建动态消息
        DynamicMessage.Builder requestBuilder = DynamicMessage.newBuilder(originMethodDescriptor.getInputType());
        requestBuilder.setField(originMethodDescriptor.getInputType().findFieldByName("id"), "1");

        DynamicMessage request = requestBuilder.build();

        // 使用 CompletableFuture 处理异步响应
        CallOptions callOptions = CallOptions.DEFAULT;
        CompletableFuture<DynamicMessage> responseFuture = new CompletableFuture<>();
        ClientCalls.asyncUnaryCall(channel.newCall(methodDescriptor, callOptions), request,
                new StreamObserver<DynamicMessage>() {
                    @Override
                    public void onNext(DynamicMessage value) {
                        responseFuture.complete(value);
                    }

                    @Override
                    public void onError(Throwable t) {
                        responseFuture.completeExceptionally(t);
                    }

                    @Override
                    public void onCompleted() {
                        // Do nothing
                    }
                });

        // 等待异步响应完成
        DynamicMessage response = responseFuture.get();
        System.out.println("Response: " + response);
        channel.shutdown();
        return "grpc-nostub";
    }

    private MethodDescriptor<DynamicMessage, DynamicMessage> generateMethodDescriptor(Descriptors.MethodDescriptor originMethodDescriptor) {
        // 生成方法全名
        String fullMethodName = MethodDescriptor.generateFullMethodName(originMethodDescriptor.getService().getFullName(), originMethodDescriptor.getName());
        // 请求和响应类型
        MethodDescriptor.Marshaller<DynamicMessage> inputTypeMarshaller = ProtoUtils.marshaller(DynamicMessage.newBuilder(originMethodDescriptor.getInputType())
                .buildPartial());
        MethodDescriptor.Marshaller<DynamicMessage> outputTypeMarshaller = ProtoUtils.marshaller(DynamicMessage.newBuilder(originMethodDescriptor.getOutputType())
                .buildPartial());

        // 生成方法描述, originMethodDescriptor 的 fullMethodName 不正确
        return MethodDescriptor.<DynamicMessage, DynamicMessage>newBuilder()
                .setFullMethodName(fullMethodName)
                .setRequestMarshaller(inputTypeMarshaller)
                .setResponseMarshaller(outputTypeMarshaller)
                // 使用 UNKNOWN，自动修改
                .setType(MethodDescriptor.MethodType.UNKNOWN)
                .build();
    }
}
