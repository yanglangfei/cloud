package com.yf.wap.controller;

import com.alipay.api.AlipayApiException;
import com.yf.wap.util.SubLineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private SubLineService subLineService;

    @GetMapping("/")
    public  String toIndex(){
        try {
            subLineService.getSubLineInfo("440300");
        } catch (AlipayApiException e) {
            e.printStackTrace();
            log.info("调用异常");
        }
        return "index";
    }


}
