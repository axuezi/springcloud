package com.vmei.ribbonservice.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vmei.ribbonservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 薛子
 * @description
 * @date 2019/9/29 0029 11:35
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    RestTemplate restTemplate;

    String url = "http://EUREKA-CLIENT/hi?name={name}";

    @Override
    @HystrixCommand(fallbackMethod = "sendError")
    public String sendMessage(String name) {
        Map param = new HashMap<>();
        param.put("name",name);
        return restTemplate.getForObject(url, String.class,param);
    }

    public String sendError(String name) {
        return "报错啦!!!";
    }
}
