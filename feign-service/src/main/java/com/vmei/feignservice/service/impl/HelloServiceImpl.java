package com.vmei.feignservice.service.impl;

import com.vmei.feignservice.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * @author 薛子
 * @description
 * @date 2019/9/29 0029 15:47
 */
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sendMessage(String name) {
        return "sorry," + name;
    }
}
