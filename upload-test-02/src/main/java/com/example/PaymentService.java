package com.example;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(String orderId, double amount) {
        System.out.println("Processing payment for order " + orderId + " of amount $" + amount);
        // 假设支付处理成功
        return true;
    }
}
