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

import com.huaweicloud.demo.providerinterface.HelloService;

import com.alipay.sofa.rpc.config.ConsumerConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daizhenyu
 * @since 2023-09-08
 **/
@RestController
@RequestMapping("sofarpc")
public class SofarpcConsumer {
    @Value("${inner.sofarpc.url}")
    private String sofarpcInnerUrl;

    @Value("${outer.sofarpc.url}")
    private String sofarpcOuterUrl;

    @RequestMapping(value = "inner", method = RequestMethod.GET)
    public String sofaClient2Inner() {

        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setDirectUrl("bolt://127.0.0.1:12200") // 指定直连地址
                .setConnectTimeout(10 * 1000);

        HelloService helloService = consumerConfig.refer();
        return helloService.sayHello("world");
    }

    @RequestMapping(value = "outer", method = RequestMethod.GET)
    public String sofaClient2Outer() {

        ConsumerConfig<HelloService> consumerConfig = new ConsumerConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setDirectUrl(sofarpcOuterUrl) // 指定直连地址
                .setConnectTimeout(10 * 1000);

        HelloService helloService = consumerConfig.refer();
        return helloService.sayHello("world");
    }
}
