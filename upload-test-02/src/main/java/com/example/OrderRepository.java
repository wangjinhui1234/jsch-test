package com.example;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    public void saveOrder(String orderId) {
        System.out.println("Order " + orderId + " saved to the database.");
    }
}
