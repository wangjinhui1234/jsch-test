package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;

    @Autowired
    public OrderService(OrderRepository orderRepository, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.paymentService = paymentService;
    }

    public void placeOrder(String orderId, double amount) {
        System.out.println("Placing order " + orderId);

        // 处理支付
        boolean paymentSuccess = paymentService.processPayment(orderId, amount);

        if (paymentSuccess) {
            orderRepository.saveOrder(orderId);
            System.out.println("Order " + orderId + " has been placed successfully.");
        } else {
            System.out.println("Payment failed for order " + orderId);
        }
    }
}



