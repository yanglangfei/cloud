package com.yf.app.controller;

import com.yf.app.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.CountDownLatch;

@RestController
@Slf4j
public class TaskController {

    private  int number=3;

    /**
     * 它允许一个或多个线程等待直到在其他线程中一组操作执行完成。
     */
    private CountDownLatch countDownLatch=new CountDownLatch(number);

    @Autowired
    private Task task;

    @GetMapping("/startTask")
    public  void  startTask(){
        try {
            task.doTaskOne();
            task.doTaskTwo();
            task.doTaskThree();
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @GetMapping("/joinTask")
    public  void  joinTask() throws InterruptedException {
        JoinTask joinTask1=new JoinTask(1);
        JoinTask joinTask2=new JoinTask(2);
        joinTask1.start();
        joinTask1.join();
        log.info("task1 is joined");
        joinTask2.start();
        joinTask2.join();
        log.info("main is end!");
    }



    class JoinTask extends Thread{
        private int number;
        public JoinTask(int number){
            this.number = number;
        }

        @Override
        public void run(){
            System.out.println("Thread"+number+" is running");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread"+number+"is end");
        }
    }




    @GetMapping("/latchTask")
    public  void  latchTask() throws InterruptedException {
        for(int i=0;i<number;i++){
            LatchThread demo = new LatchThread(countDownLatch);
            demo.start();
            log.info("i : {} ",i);
        }
        countDownLatch.await();
        log.info("Check it Out");
    }



    public  class  LatchThread extends Thread{

        private  CountDownLatch countDownLatch;

        public LatchThread(CountDownLatch countDownLatch) {
            this.countDownLatch=countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }
    }

}
