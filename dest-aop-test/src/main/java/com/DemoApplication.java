package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private SampleService sampleService;

    @Autowired
    private adivce adivce;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
       // sampleService.doSomething();
         //  sampleService.eating();
      //   sampleService.play();

        System.out.println("----------------------------");

        sampleService.happy();

    }
}
