package com.yf.gateway.util;
import com.netflix.zuul.context.RequestContext;
import com.yf.gateway.filter.CtxEnum;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QianJH
 * @date 2018/02/05
 */
public final class RouterUtils {

    /**
     * 返回失败
     *
     * @param ctx
     */
    public synchronized static void respError(RequestContext ctx) {
        ctx.set(CtxEnum.STOP_NEXT_FILTER, true);
        ctx.setSendZuulResponse(false);//停止继续路由
        ctx.setResponseStatusCode(HttpStatus.OK.value());
        ctx.addZuulResponseHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON.toString());
        ctx.setResponseBody("返回失败");
    }

    /**
     * 重定向
     *
     * @param ctx
     * @param redirectUrl
     * @throws IOException
     */
    public synchronized static void redirect(RequestContext ctx, String redirectUrl) {
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("UTF-8");
        ctx.set(CtxEnum.STOP_NEXT_FILTER, true);
        //停止继续路由
        ctx.setSendZuulResponse(false);
        ctx.setResponseStatusCode(HttpStatus.OK.value());
        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
          //  throw new ServiceException("重定向失败: {" + redirectUrl + "}");
        }
    }
}
