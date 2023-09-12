/*
 * Copyright (C) 2022-2022 Huawei Technologies Co., Ltd. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.huaweicloud.demo.controller;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

/**
 * 使用http客户端调用同一进程的服务端
 *
 * @author daizhenyu
 * @since 2023-09-07
 **/
@Controller
@ResponseBody
@RequestMapping(value = "produce")
public class ProducerController {
    public final static String TOPIC = "traffic_tag_test";
    public final static String TIME_FORMAT = "yyyy/MM/dd HH:mm:ss";

    public final static String TAG = "";
    public final static String ROCKETMQ_IP_ADDRESS = "127.0.0.1:9876";
    public final static String ROCKETMQ_PRODUCE_GROUP = "producer_group";
    public final static String MESSAGE_BODY_ROCKET = "hello outer rocketmq:";

    public final static String KAFKA_KEY = "trafficTag";
    public final static String KAFKA_IP_ADDRESS = "127.0.0.1:9092";
    public final static String MESSAGE_BODY_KAFKA = "hello outer kafka:";

    @RequestMapping(value = "rocketmq", method = RequestMethod.GET)
    public String testRocketMqProducer()
            throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        produceRocketData();
        return "rocket-producer-test";
    }

    @RequestMapping(value = "kafka", method = RequestMethod.GET)
    public String testKafkaProducer() {
        produceKafkaData();
        return "kafka-producer-test";
    }

    private void produceRocketData()
            throws RemotingException, InterruptedException, MQBrokerException, MQClientException {

        DefaultMQProducer producer = new DefaultMQProducer(ROCKETMQ_PRODUCE_GROUP);
        producer.setNamesrvAddr(ROCKETMQ_IP_ADDRESS);
        producer.start();

        String messageBody = buildMessageBody(MESSAGE_BODY_ROCKET);

        Message message = new Message(TOPIC, TAG, messageBody.getBytes(StandardCharsets.UTF_8));
        SendResult send = producer.send(message);
        System.out.println(send.getSendStatus());
        producer.shutdown();
    }

    private void produceKafkaData() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", KAFKA_IP_ADDRESS);
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(properties);

        String messageBody = buildMessageBody(MESSAGE_BODY_KAFKA);

        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, KAFKA_KEY, messageBody);

        producer.send(record, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println("Message sent successfully. Offset: " + metadata.offset());
                } else {
                    System.err.println("Error sending message: " + exception.getMessage());
                }
            }
        });
        producer.close();
    }

    private String buildMessageBody(String body) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(TIME_FORMAT);
        String messageBody = body + dtf.format(LocalDateTime.now());
        return messageBody;
    }
}