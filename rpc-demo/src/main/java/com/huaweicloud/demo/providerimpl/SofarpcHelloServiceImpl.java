/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.huaweicloud.demo.providerimpl;

import com.huaweicloud.demo.providerinterface.HelloService;
import com.huaweicloud.demo.utils.HttpClientUtils;

import org.springframework.beans.factory.annotation.Value;

/**
 * Quick Start demo implements
 */
public class SofarpcHelloServiceImpl implements HelloService {
    @Value("${commonServerUrl}")
    private String commonServerUrl;

    @Override
    public String sayHello(String string) {
        HttpClientUtils.doHttpClientV4GET("http://127.0.0.1:8080/common/httpserver");
        return "hello sofarpc";
    }
}