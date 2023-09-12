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

package com.huaweicloud.demo.providerimpl;

import com.huaweicloud.demo.common.Constant;
import com.huaweicloud.demo.providerinterface.AlibabaGreetingOuterService;
import com.huaweicloud.demo.utils.HttpClientUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.rpc.RpcContext;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author daizhenyu
 * @since 2023-09-08
 **/
@Service
public class GreetingServiceApacheDubboImpl implements AlibabaGreetingOuterService {
    @Value("${commonServerUrl}")
    private String commonServerUrl;

    @Override
    public String sayHello(String name) {
        RpcContext rpcContext = RpcContext.getContext();
        System.out.println(buildString(rpcContext));
        HttpClientUtils.doHttpClientV4GET("http://127.0.0.1:8080/common/httpserver");
        return "hello apache dubbo";
    }

    private static String buildString(RpcContext rpcContext) {
        StringBuilder builder = new StringBuilder();
        builder.append("dubbo consumer端流量标签为: ");
        builder.append("{");
        for (String s : Constant.TRAFFIC_TAG_KEY) {
            builder.append(s);
            builder.append(":");
            builder.append(rpcContext.getAttachment(s));
            builder.append(";");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("}");
        return builder.toString();
    }
}
