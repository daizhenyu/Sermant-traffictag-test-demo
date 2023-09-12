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

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * rocketmq 消费者
 *
 * @author daizhenyu
 * @since 2023-09-08
 **/
@Component
public class RocketMqWithConsumer implements CommandLineRunner {
    @Value("${commonServerUrl}")
    private String commonServerUrl;

    public final static String CONSUME_GROUP = "consume_group";
    public final static String IP_ADDRESS = "127.0.0.1:9876";
    public final static String TOPIC = "traffic_tag_test";
    public final static String TAG_SCOPE = "*";

    @Override
    public void run(String... args) throws Exception {
        System.out.println("rocketmq消费者启动");
        consumeData();
    }

    private void  consumeData() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(CONSUME_GROUP);
        consumer.setNamesrvAddr(IP_ADDRESS);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe(TOPIC, TAG_SCOPE);
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> messageExts,
                    ConsumeOrderlyContext context) {
                if (messageExts != null) {
                    for (MessageExt ext : messageExts) {
                        System.out.println(ext.getBody());
                        System.out.println(ext.getProperties().get(Constant.TRAFFIC_TAG_KEY));
                        // 创建HttpClient实例
                        HttpClientUtils.doHttpClientV4GET(commonServerUrl);
                    }
                }
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });
        consumer.start();
    }
}