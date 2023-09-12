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

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

package com.huaweicloud.demo.grpc;

public final class ProductProto {
  private ProductProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_product_Product_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_product_Product_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_product_ProductId_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_product_ProductId_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\rproduct.proto\022\007product\"G\n\007Product\022\n\n\002i" +
      "d\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\023\n\013description\030\003 \001" +
      "(\t\022\r\n\005price\030\004 \001(\002\"\032\n\tProductId\022\r\n\005value\030" +
      "\001 \001(\t2\235\002\n\013ProductInfo\0222\n\naddProduct\022\020.pr" +
      "oduct.Product\032\022.product.ProductId\0226\n\014che" +
      "ckProduct\022\020.product.Product\032\022.product.Pr" +
      "oductId0\001\0225\n\013addProducts\022\020.product.Produ" +
      "ct\032\022.product.ProductId(\001\0227\n\013getProducts\022" +
      "\022.product.ProductId\032\020.product.Product(\0010" +
      "\001\0222\n\ngetProduct\022\022.product.ProductId\032\020.pr" +
      "oduct.ProductB\'\n\025org.javaboy.grpc.demoB\014" +
      "ProductProtoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_product_Product_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_product_Product_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_product_Product_descriptor,
        new String[] { "Id", "Name", "Description", "Price", });
    internal_static_product_ProductId_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_product_ProductId_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_product_ProductId_descriptor,
        new String[] { "Value", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
