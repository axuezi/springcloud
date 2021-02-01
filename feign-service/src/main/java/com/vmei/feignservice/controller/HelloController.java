package com.vmei.feignservice.controller;

import com.vmei.feignservice.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 薛子
 * @date 2019/9/29 0029 11:41
 */
@RestController
public class HelloController {

    @Resource
    HelloService helloService;

    @GetMapping("hi")
    public String getHello(){
        String name = "axue";
        return helloService.sendMessage(name);
    }
}
