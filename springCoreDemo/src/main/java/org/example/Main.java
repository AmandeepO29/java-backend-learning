package org.example;

import in.strikes.cartService;
import org.example.payment.paymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // context is an ioc container , jo hame beans available krvayega jo bhi needed hai

        // yha se hme orderService class ka bean milega jo ki order me stored hai
        orderService order = context.getBean(orderService.class);
        order.placeOrder();

        //yha se hme paymentService class ka bean milega jo ki order me stored hai
//        paymentService payment=context.getBean(paymentService.class);
//        payment.pay();

//        cartService cs = new cartService();
//        cs.addToCart();
        user user=context.getBean(user.class);
        System.out.println(user.getName());
        System.out.println(user.getAge());

        cartService cs = context.getBean(cartService.class);
        cs.addToCart();
    }
}
