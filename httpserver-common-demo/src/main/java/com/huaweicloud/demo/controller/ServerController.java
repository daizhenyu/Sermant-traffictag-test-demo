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

import com.huaweicloud.demo.StringUtils;
import com.huaweicloud.demo.common.Constant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 公共的httpserver，用于验证各组件服务端可以将流量标签透传至下游服务
 *
 * @author daizhenyu
 * @since 2023-09-07
 **/
@RestController
@RequestMapping("common")
public class ServerController {

    @RequestMapping(value = "httpserver", method = RequestMethod.GET)
    public String testHttpServer(HttpServletRequest request) {
        StringUtils.printString(request);
        return "common-httpserver-test";
    }
}
