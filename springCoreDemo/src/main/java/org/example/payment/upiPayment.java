package org.example.payment;

import org.springframework.stereotype.Component;

@Component
public class upiPayment implements paymentService{
    @Override
    public void pay() {
        System.out.println("Paying via UPI");
    }
}
