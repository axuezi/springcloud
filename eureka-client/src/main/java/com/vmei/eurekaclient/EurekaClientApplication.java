package com.vmei.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 消费段服务注册类
 *
 * @author  薛子
 * @date  2019/10/30 0030 10:52
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    /**
     * 启动方法
     *
     * @author 薛子
     * @date 2019/10/30 0030 10:51
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}
