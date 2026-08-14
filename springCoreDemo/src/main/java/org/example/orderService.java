package org.example;

import org.example.payment.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class orderService {
    private  paymentService paymentservice;
    @Autowired
    public orderService(paymentService paymentservice){
    this.paymentservice=paymentservice;
    }
    public void placeOrder(){
        paymentservice.pay();
        System.out.println("Order placed");
    }
}
