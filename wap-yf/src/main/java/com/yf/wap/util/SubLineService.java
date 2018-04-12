package com.yf.wap.util;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayCommerceCityfacilitatorStationQueryRequest;
import com.alipay.api.response.AlipayCommerceCityfacilitatorStationQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SubLineService {

    @Value("${alipay.private_key}")
    private String alipayPrivateKey;
    @Value("${alipay.app_id}")
    private String alipayAppId;
    @Value("${alipay.public_key}")
    private String alipayPublicKey;
    @Value("${alipay.server_url}")
    private String alipayServerUrl;

    public void getSubLineInfo(String cityCode) throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                alipayServerUrl,
                alipayAppId,
                alipayPrivateKey,
                "json",
                "GBK",
                alipayPublicKey,
                "RSA2");
        AlipayCommerceCityfacilitatorStationQueryRequest request = new AlipayCommerceCityfacilitatorStationQueryRequest();
        request.setBizContent("{" +
                "\"city_code\":\""+cityCode+"\"" +
                "  }");
        AlipayCommerceCityfacilitatorStationQueryResponse response = alipayClient.execute(request);
        if (response.isSuccess()) {
            log.info("调用成功:",response);
        } else {
            log.info("调用成功:",response);
        }
    }


}
