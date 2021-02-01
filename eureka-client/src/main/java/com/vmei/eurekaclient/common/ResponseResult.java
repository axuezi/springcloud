package com.vmei.eurekaclient.common;

import java.lang.annotation.*;

/**
 * 拦截请求，判断此请求是否需要被@ResponseResult注解
 *
 * @author axue
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {

}
