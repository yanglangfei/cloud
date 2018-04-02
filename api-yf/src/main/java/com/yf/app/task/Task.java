package com.yf.app.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class Task {

    private Random random = new Random();

    @Async("taskExecutor")
    public void doTaskOne() throws Exception {
        log.info("task one is runing");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (endTime - startTime) + "毫秒");
    }

    @Async("taskExecutor")
    public void doTaskTwo() throws Exception {
        log.info("task two is runing");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (endTime - startTime) + "毫秒");
    }


    @Async("taskExecutor")
    public void doTaskThree() throws Exception {
        log.info("task three is runing");
        long startTime = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long endTime = System.currentTimeMillis();
        log.info("完成任务三，耗时：" + (endTime - startTime) + "毫秒");
    }
}
