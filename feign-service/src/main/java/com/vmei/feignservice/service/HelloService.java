package com.vmei.feignservice.service;

import com.vmei.feignservice.service.impl.HelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 * @author 薛子
 * @description
 * @date 2019/9/29 0029 11:35
 */
@FeignClient(value = "EUREKA-CLIENT",fallback = HelloServiceImpl.class )
public interface HelloService {

    /**
     * 发送消息
     *
     * @author  薛子
     * @date  2019/10/30 0030 13:35
     * @param name :
     * @return String
     */
    @GetMapping("/hi")
    String sendMessage(@RequestParam(value = "name") String name);

}
