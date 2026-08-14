package in.strikes;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
// due to this lazy payment service object not created till when order.placeOrder() is called;
//        as it needs pay() method for which object needs to be created
public class PaymentService {
    public PaymentService(){
        System.out.println("Payment service created");
    }

    public void pay() {
        System.out.println("payment done");
    }
}
