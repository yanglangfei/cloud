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
import org.springframework.data.redis.core.ValueOperations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * 请求日志过滤器
 */
@Slf4j
@RefreshScope
public class AccessLogFilter extends ZuulFilter {

    @Value("${define.zuul.filter.AccessLogFilter.enable}")
    private  boolean shouldFilter;

    @Value("${define.limit.access}")
    private Integer limitAccess;

    private  String ACCESS_TOKEN_KEY="USER_ACCESS_";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


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
        return shouldFilter;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("UTF-8");
        String clientIp = HttpUtils.getClientIp(request);
        String method = request.getMethod();
        String requestUrl = request.getRequestURL().toString();
        String requestParams = HttpUtils.getRequestParams(request);

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        if(!stringRedisTemplate.hasKey(ACCESS_TOKEN_KEY+clientIp+requestUrl)){
            opsForValue.set(ACCESS_TOKEN_KEY+clientIp+requestUrl,"1",1, TimeUnit.MINUTES);
        }
        Long countHour = opsForValue.increment(ACCESS_TOKEN_KEY+clientIp+requestUrl, 1L);

       if(countHour>limitAccess){
           log.info("请求[{}]分钟内请求量[{}],加入过滤", requestUrl, countHour);
           RouterUtils.respError(ctx, RespVOBuilder.failure("拒绝访问"));
       }

        log.info(String.format("Request -> IP: %s, Method: %s, URL: %s, Params: %s",
                clientIp , method,requestUrl ,requestParams));

        return null;
    }
}
