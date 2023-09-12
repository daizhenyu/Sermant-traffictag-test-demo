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

import com.huaweicloud.demo.utils.HttpClientUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 使用http客户端调用同一进程的服务端
 *
 * @author daizhenyu
 * @since 2023-09-07
 **/
@Controller
@ResponseBody
@RequestMapping(value = "inner")
public class InnerClientController {
    @Value("${innerServerUrl}")
    private String innerServerUrl;

    @RequestMapping(value = "httpclientv3", method = RequestMethod.GET)
    public String testHttpClientV3() {
        HttpClientUtils.doHttpClientV3GET(innerServerUrl);
        return "inner-httpclientv3-test";
    }

    @RequestMapping(value = "httpclientv4", method = RequestMethod.GET)
    public String testHttpClientV4() {
        HttpClientUtils.doHttpClientV4GET(innerServerUrl);
        return "inner-httpclientv4-test";
    }

    @RequestMapping(value = "okhttp", method = RequestMethod.GET)
    public String testOkHttp() {
        HttpClientUtils.doOkHttpGET(innerServerUrl);
        return "inner-okhttp-test";
    }

    @RequestMapping(value = "jdkhttp", method = RequestMethod.GET)
    public String testJdkHttp() {
        HttpClientUtils.doHttpUrlConnectionGET(innerServerUrl);
        return "inner-okhttp-test";
    }
}