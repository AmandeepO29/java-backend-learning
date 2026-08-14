package in.strikes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ConfigurableApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        // here meta-data of appconfig.class is passed ..... which is taken by context(ioc container)
//        OrderService order = context.getBean(OrderService.class);
//        order.placeOrder();
//        AppConfig config = context.getBean(AppConfig.class);
//        config.demo();
//        UserService userService=context.getBean(UserService.class);
//        userService.setBeanName("userBean2 ");

        CartService cs=context.getBean(CartService.class);
        System.out.println(cs.getValue(1));

        context.close();// this is used to call destruction callbacks
    }
}
