package com.vmei.eurekaclient.contrller;

import com.vmei.eurekaclient.common.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试接口
 *
 * @author axue
 */
@RestController
@ResponseResult
public class HelloWorld {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hi")
    public Object home(@RequestParam String name) {
        return "hello,+" + name + "---------------->>>" + port;
    }

}
