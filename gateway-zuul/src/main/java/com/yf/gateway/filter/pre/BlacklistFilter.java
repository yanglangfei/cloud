package com.yf.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yf.gateway.filter.CtxEnum;
import com.yf.gateway.util.HttpUtils;
import com.yf.gateway.util.RouterUtils;
import com.yf.lib.vo.RespVOBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 黑名单  拦截
 */
@Slf4j
@RefreshScope
public class BlacklistFilter extends ZuulFilter {

    private static final String BLACKLIST_PREFIX = "BLACKLIST_";
    @Autowired
    protected StringRedisTemplate stringRedisTemplate;

    @Value("${define.zuul.filter.BlacklistFilter.enable}")
    private  boolean shouldFilter;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //是否停止过滤
        if (ctx.containsKey(CtxEnum.STOP_NEXT_FILTER)) {
            return false;
        }
        return shouldFilter;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("UTF-8");

        String ip = HttpUtils.getClientIp(request);

        if (stringRedisTemplate.hasKey(BLACKLIST_PREFIX + ip)) {
            RouterUtils.respError(ctx, RespVOBuilder.failure("拒绝访问"));
        }

        return null;
    }
}
