package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");

/*          get bean by id/name*/
//        OrderService orderService= (OrderService) context.getBean("orderService");
//        orderService.placeOrder();

        /* get bean by type/class name
         this method is used only when there is unique bean in class
         if there  are multiple beans with same class then it will show NoUniqueBeanDefinition exception
         this shows error due to multiple beans*/
//        OrderService orderService1=context.getBean(OrderService.class);
//        orderService1.placeOrder();
        /* to solve this use both id , type*/

        /*can be fetched by bean name also*/
//        OrderService orderService=context.getBean("orderService",OrderService.class);
//        orderService.placeOrder();


//        PaymentService paymentService = context.getBean("paymentService" , PaymentService.class);
//        paymentService.pay();
//        orderService2.placeOrder();

        UserService user=context.getBean(UserService.class);
        context.close(); /*this calls the cleanup method */

    }
}
