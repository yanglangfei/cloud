package com.yf.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yf.gateway.filter.CtxEnum;
import com.yf.gateway.util.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AccessLogFilter extends ZuulFilter {

    private  boolean shouldFilter;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //是否停止过滤
        if (ctx.containsKey(CtxEnum.STOP_NEXT_FILTER)) {
            return false;
        }
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("UTF-8");

        log.info(String.format("Request -> IP: %s, Method: %s, URL: %s, Params: %s",
                HttpUtils.getClientIp(request), request.getMethod(), request.getRequestURL().toString(), HttpUtils.getRequestParams(request)));

        return null;
    }
}
