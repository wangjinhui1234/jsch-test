package kaer;

import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.util.Arrays.*;

public class hello {
    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://localhost:6379")
                .setPassword("123456");
        RedissonClient client = Redisson.create(config);
        RCountDownLatch countDownLatch = client.getCountDownLatch("countDownLatch");
        countDownLatch.trySetCount(20);
        RBucket<String> bucket = client.getBucket("bucket");
        bucket.set("桶测试"+1);
        String oldValue=bucket.get();
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        for (int i=0;i<20;i++){
            executorService.submit(() -> {
                System.out.println("线程:" + Thread.currentThread().getId() + ",桶:" + bucket.get());
                if (bucket.compareAndSet(oldValue, "桶测试 " + 2)) {
                    System.out.println("线程" + Thread.currentThread().getId() + "更新了bucket的值");
                }
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("更新后的桶对象为："+bucket.get());
        executorService.shutdown();
    }
        }

