package org.example.payment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class cardPayment implements paymentService{
    @Override
    public void pay() {
        System.out.println("payment done by card");
    }
}
