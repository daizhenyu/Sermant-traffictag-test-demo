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

import com.huaweicloud.demo.common.Constant;

import javax.servlet.http.HttpServletRequest;

/**
 * @author daizhenyu
 * @since 2023-09-11
 **/
public class StringUtils {
    public static void printString(HttpServletRequest request) {
        System.out.println("client端透传的流量标签为: " +  buildString(request));
    }

    private static String buildString(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (String s : Constant.TRAFFIC_TAG_KEY) {
            builder.append(s);
            builder.append(":");
            builder.append(request.getHeader(s));
            builder.append(";");
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append("}");
        return builder.toString();
    }
}
