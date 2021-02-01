package com.vmei.ribbonservice.controller;

import com.vmei.ribbonservice.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 薛子
 * @description
 * @date 2019/9/29 0029 11:41
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("hi")
    public String getHello(HttpServletResponse response) throws IOException {
        String name = "axue";
        return helloService.sendMessage(name);
    }
}
