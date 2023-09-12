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

import com.huaweicloud.demo.common.Constant;
import com.huaweicloud.demo.utils.HttpClientUtils;
import com.huaweicloud.demo.utils.StringUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * http Server端
 *
 * @author daizhenyu
 * @since 2023-09-07
 **/
@Controller
@ResponseBody
@RequestMapping(value = "tomcat")
public class ServerController {
    @Value("${commonServerUrl}")
    private String commonServerUrl = "http://127.0.0.1:8080/";

    @RequestMapping(value = "httpserver", method = RequestMethod.GET)
    public String testHttpServer(HttpServletRequest request) {
        StringUtils.printString(request);
//        assert request.getHeader(Constant.TRAFFIC_TAG_KEY).equals(Constant.TRAFFIC_TAG_VALUE);
        HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        return "inner-httpserver-test";
    }
}
