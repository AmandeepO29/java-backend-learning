package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService order=context.getBean(OrderService.class);
        OrderService order2 = context.getBean(OrderService.class);

        // here order and order 2 have same reference in singleton scope , but we can create new object
        //manually

        OrderService order3 = new OrderService();


//        order2.placeOrder();
//        order.placeOrder();
        System.out.println(order==order2);
    }
}
