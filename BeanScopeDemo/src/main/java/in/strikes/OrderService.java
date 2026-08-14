package in.strikes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Scope("singleton")
public class OrderService {
    public OrderService(){
        System.out.println("order service created");
    }

    public void placeOrder(){
        System.out.println("Order placed");
    }
}
