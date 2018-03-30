package com.yf.gateway.util;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *
 */
public final class HttpUtils {

    /**
     * @param request
     * @return
     */
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");

        //从请求头获取代理前真实IP
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        //
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (StringUtils.isNotBlank(ip)) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * @param request
     * @return
     */
    public static String getRequestParams(HttpServletRequest request) {
        Map<String, String[]> paramMap = request.getParameterMap();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (String key : paramMap.keySet()) {
            if (k != 0) {
                sb.append(", ");
            }
            sb.append(key).append("=[");
            String[] vals = paramMap.get(key);
            for (int i = 0; i < vals.length; i++) {
                String val = vals[i];
                if (i != 0) {
                    sb.append(", ");
                }
                sb.append(val);
            }
            sb.append("]");
            k++;
        }
        return sb.toString();
    }
}
