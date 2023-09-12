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

package com.huaweicloud.demo;

import com.huaweicloud.demo.providerimpl.SofarpcHelloServiceImpl;
import com.huaweicloud.demo.providerinterface.HelloService;

import com.alipay.sofa.rpc.config.ProviderConfig;
import com.alipay.sofa.rpc.config.ServerConfig;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author daizhenyu
 * @since 2023-09-12
 **/
@EnableDubbo
@SpringBootApplication
public class RpcServerApplication {
    public static void main(String[] args) {
        ServerConfig serverConfig = new ServerConfig()
                .setProtocol("bolt") // 设置一个协议，默认bolt
                .setPort(12201) // 设置一个端口，默认12200
                .setDaemon(false); // 非守护线程

        ProviderConfig<HelloService> providerConfig = new ProviderConfig<HelloService>()
                .setInterfaceId(HelloService.class.getName()) // 指定接口
                .setRef(new SofarpcHelloServiceImpl()) // 指定实现
                .setServer(serverConfig); // 指定服务端

        providerConfig.export(); // 发布服务
        SpringApplication.run(RpcServerApplication.class, args);
    }
}
