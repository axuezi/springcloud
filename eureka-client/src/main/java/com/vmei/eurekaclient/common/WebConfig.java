package com.vmei.eurekaclient.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 注册拦截器
 *
 * @author axue
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 初始化返回拦截器
     *
     * @return ResponseResultInterceptor
     */
    ResponseResultInterceptor responseResultInterceptor() {
        return new ResponseResultInterceptor();
    }

    /**
     * 配置拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册该自定义的登陆拦截器
        registry.addInterceptor(responseResultInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html")
                .excludePathPatterns("/api/login")
                .excludePathPatterns("/api/logout");
    }

    /**
     * 处理 spring 框架提供的转换器
     *
     * @param converters 转换器
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 第二种就是把String类型的转换器去掉，不使用String类型的转换器
        converters.removeIf(httpMessageConverter -> httpMessageConverter.getClass() == StringHttpMessageConverter.class);
    }
}
