// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: product.proto

package org.javaboy.grpc.demo;

public interface ProductOrBuilder extends
    // @@protoc_insertion_point(interface_extends:product.Product)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string id = 1;</code>
   * @return The id.
   */
  String getId();
  /**
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>string description = 3;</code>
   * @return The description.
   */
  String getDescription();
  /**
   * <code>string description = 3;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>float price = 4;</code>
   * @return The price.
   */
  float getPrice();
}
