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

package com.huaweicloud.demo.utils;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * http客户端工具类
 *
 * @author daizhenyu
 * @since 2023-09-07
 **/
public class HttpClientUtils {
    public static void doHttpClientV3GET(String url) {
        // 创建 HttpClient 实例
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        try {
            // 执行 GET 请求
            int statusCode = httpClient.executeMethod(getMethod);
            System.out.println("status code: " + statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放连接
            getMethod.releaseConnection();
        }
    }

    public static void doHttpClientV4GET(String url) {
        // 创建 CloseableHttpClient 实例
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            // 执行 GET 请求
            CloseableHttpResponse response = httpClient.execute(httpGet);
            System.out.println("status code: " + response.getStatusLine().getStatusCode());
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void doOkHttpGET(String url) {
        OkHttpClient client = new OkHttpClient();

        // 创建 HTTP 请求
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            // 执行请求
            Response response = client.newCall(request).execute();
            System.out.println("status code: " + response.code());
            response.body().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void doHttpUrlConnectionGET(String url) {
        try {
            // 创建 URL 对象
            URL serverUrl = new URL(url);
            // 打开连接
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            // 设置请求方法
            connection.setRequestMethod("GET");

            // 获取响应码
            connection.getResponseCode();

            // 读取响应数据
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            System.out.println(content);
            in.close();
            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
