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

package com.huaweicloud.demo.controller;

import com.huaweicloud.demo.common.Constant;
import com.huaweicloud.demo.utils.HttpClientUtils;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.header.Header;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Properties;

/**
 * kafka消费者
 *
 * @author daizhenyu
 * @since 2023-09-08
 **/
@Component
public class KafkaWithConsumer implements CommandLineRunner {
    @Value("${commonServerUrl}")
    private String commonServerUrl;

    public final static String TOPIC = "traffic_tag_test";

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("group.id", "my-group");
        properties.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        consumer.subscribe(Collections.singletonList(TOPIC));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);

            for (ConsumerRecord<String, String> record : records) {
                for (Header header : record.headers()) {
                    if (header.key().equals(Constant.TRAFFIC_TAG_VALUE)) {
                        System.out.println("client端透传的流量标签为：" + "{" + Constant.TRAFFIC_TAG_KEY + ":"
                                + new String(header.value(), StandardCharsets.UTF_8) + "}" );
                    }
                }
                System.out.println("Received message: " + record.value());
                HttpClientUtils.doHttpClientV4GET(commonServerUrl);
            }
        }
    }
}
