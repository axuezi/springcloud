package com.vmei.zuulservice.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 服务过滤(zuul不仅只是路由 ， 并且还能过滤 ， 做一些安全验证)
 *
 * @author 薛子
 * @date 2019/9/30 0030 9:31
 */
@Component
public class MyFilter extends ZuulFilter {

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * ### pre:路由之前 ### routing:路由之时 ### post:路由之后 ### error:发送错误调用
     *
     * @author 薛子
     * @date 2019/9/30 0030 9:44
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * @author 薛子
     * @date 2019/9/30 0030 9:36
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 逻辑判断，是否要过滤，本文true,永远过滤。
     *
     * @author 薛子
     * @date 2019/9/30 0030 9:36
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
     *
     * @author 薛子
     * @date 2019/9/30 0030 9:37
     */
    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("token is empty!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
