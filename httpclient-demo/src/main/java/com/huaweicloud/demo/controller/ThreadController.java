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

import com.huaweicloud.demo.utils.HttpClientUtils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author daizhenyu
 * @since 2023-09-11
 **/
@Controller
@ResponseBody
@RequestMapping(value = "thread")
public class ThreadController {
    @Value("${commonServerUrl}")
    private String commonServerUrl;

    ThreadPoolExecutor executor;

    ScheduledExecutorService scheduledExecutor;

    @RequestMapping(value = "newthread", method = RequestMethod.GET)
    public String newThreadTest() {
        Thread thread = new Thread(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        });
        thread.start();
        return "new thread";
    }

    @RequestMapping(value = "executor", method = RequestMethod.GET)
    public String executorTest() {
        executor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        executor.execute(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return "executor";
    }

    @RequestMapping(value = "submit", method = RequestMethod.GET)
    public String submitTest() {
        executor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        executor.submit(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        });
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
        return "submit";
    }

    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public String scheduleTest() {
        scheduledExecutor = Executors.newScheduledThreadPool(5);
        scheduledExecutor.schedule(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        }, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutor.shutdown();
        }
        return "schedule";
    }

    @RequestMapping(value = "scheduleAtFixedRate", method = RequestMethod.GET)
    public String scheduleAtFixedRateTest() {
        scheduledExecutor = Executors.newScheduledThreadPool(5);
        scheduledExecutor.scheduleAtFixedRate(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        }, 1, 10, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutor.shutdown();
        }
        return "scheduleAtFixedRate";
    }

    @RequestMapping(value = "scheduleWithFixedDelay", method = RequestMethod.GET)
    public String scheduleWithFixedDelayTest() {
        scheduledExecutor = Executors.newScheduledThreadPool(5);
        scheduledExecutor.scheduleWithFixedDelay(() -> {
            HttpClientUtils.doHttpClientV4GET(commonServerUrl);
        }, 1, 10, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutor.shutdown();
        }
        return "scheduleWithFixedDelay";
    }
}
