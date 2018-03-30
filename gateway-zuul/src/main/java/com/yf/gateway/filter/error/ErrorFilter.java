package com.yf.gateway.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yf.gateway.util.RouterUtils;
import com.yf.lib.vo.RespVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

/**
 * 网关异常处理
 */
@Slf4j
@RefreshScope
public class ErrorFilter extends ZuulFilter {

    @Value("${define.zuul.filter.ErrorFilter.enable}")
    private boolean shouldFilter;

    @Override
    public String filterType() {
        return FilterConstants.ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return shouldFilter;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.error(String.format("过滤器GatewayExceptionFilter执行信息 -> %s", ctx.getFilterExecutionSummary().toString()));
        Throwable e = ctx.getThrowable();
        e.printStackTrace();

        RouterUtils.respError(ctx, RespVOBuilder.failure());
        return null;
    }
}
