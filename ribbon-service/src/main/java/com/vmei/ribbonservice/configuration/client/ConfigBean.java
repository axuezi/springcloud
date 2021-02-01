package com.vmei.ribbonservice.configuration.client;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 薛子
 * @description
 * @date 2019/9/29 0029 11:29
 */
@Configuration
public class ConfigBean {

    /**
     * @LoadBalanced 注解表明这个restRemplate开启负载均衡的功能
     * Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具
     *
     * @author 薛子
     * @date 2019/9/29 0029 11:31
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule MyRule() {
        //return new RoundRobinRule();
        //return new RandomRule();//达到的目的，用我们重新选择的随机算法替代默认的轮询。
        return new RetryRule();
    }
}
