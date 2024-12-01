package com;

import org.springframework.stereotype.Service;

@Service
public class SampleService {


    public void doSomething(){
        System.out.println("Doing something...");
        try {
            Thread.sleep(1000);
            System.out.println("这是2");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    @AroundCutPoint
    public void eating() throws InterruptedException {
        System.out.println("eating 代码");
        Thread.sleep(1000);
        System.out.println("========");
    }


    @BeforeCutPoint
    public void play() throws InterruptedException {
        System.out.println("paly代码");
        Thread.sleep(1000);
        System.out.println("======================================f");
    }

    @AfterCutPoint
    public void happy() throws InterruptedException {
        System.out.println("happy代码");
        Thread.sleep(1000);
        System.out.println("=========================================");
    }

}
