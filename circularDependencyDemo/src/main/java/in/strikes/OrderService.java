package in.strikes;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private PaymentService paymentService;
    public OrderService(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    public void placeOrder(){
        System.out.println("Order placed");
    }

    public void getOrderDetails(){
        System.out.println("Order Details");
    }

}
