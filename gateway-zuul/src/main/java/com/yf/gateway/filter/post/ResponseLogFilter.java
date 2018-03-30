package com.yf.gateway.filter.post;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 响应日志
 */
@Slf4j
@RefreshScope
public class ResponseLogFilter extends ZuulFilter {

    @Value("${define.zuul.filter.ResponseLogFilter.enable}")
    private boolean shouldFilter;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 9999;
    }

    @Override
    public boolean shouldFilter() {
        return shouldFilter;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.info(String.format("Response -> %s", ctx.getFilterExecutionSummary().toString()));
        return null;
    }
}
