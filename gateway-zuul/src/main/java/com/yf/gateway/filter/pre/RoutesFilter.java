package com.yf.gateway.filter.pre;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.yf.gateway.filter.CtxEnum;
import com.yf.gateway.util.RouterUtils;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;

/**
 * 路由转发过滤器
 */
@Slf4j
@RefreshScope
public class RoutesFilter extends ZuulFilter {

    @Value("${define.zuul.filter.RoutesFilter.enable}")
    private boolean shouldFilter;

    @Override
    public String filterType() {
        //前置过滤器，例如鉴权、请求转发、增加请求参数等行为
        //后置过滤器， 统计返回值和调用时间、记录日志、增加跨域头等行为
        //错误过滤器, 以在 Gateway 遇到错误逻辑时直接抛出异常中断流程，并直接统一处理返回结果
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 2;
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
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        // 1、根据 url 重定向 到 指定的地址
       // RouterUtils.redirect(requestContext,"http://www.baidu.com");
        // 2、根据 header 转发到 指定 的 service 服务
       /* String version = request.getHeader("version");

        if(null!=version){
            //根据  metadata-map 值 转发到对应的 app service
            RibbonFilterContextHolder.getCurrentContext().add("version",version);
        }*/
        return null;
    }
}
