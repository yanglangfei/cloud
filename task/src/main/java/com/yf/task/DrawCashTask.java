package com.yf.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Slf4j
public class DrawCashTask {

    @Scheduled(fixedRate = 2000)
    public  void  run(){
        log.info("task is runing:"+ LocalDate.now());

    }

}
