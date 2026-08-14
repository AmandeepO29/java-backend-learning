package in.strikes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;
    public OrderService(@Lazy PaymentService paymentService){
        // due to lazy ioc will pass a proxy(seems same as object i.e fake paymentService)
        // of paymentService ,will not actually create a object
        this.paymentService=paymentService;

        System.out.println("order service created");
    }
    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order placed");
    }
}
