package com.example.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {

     private final static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre"; //"pre"代表会在请求被路由之前执行
    }

    @Override
    public int filterOrder() {
        return 0;//过滤器的执行顺序。当请求在一个阶段中存在多个过滤器时， 需要根据该方法返回的值来依次执行
    }

    @Override
    public boolean shouldFilter() {
        return true;//true代表拦截器对请求生效
    }

    @Override
    public Object run() {
        log.info("into run...");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String accessToken = request.getParameter("accessToken");
        if(StringUtils.isEmpty(accessToken)){
            log.warn("accessToken is empty");
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            return null;
        }
        log.info("accessToken is ok");
        return null;
    }
}
