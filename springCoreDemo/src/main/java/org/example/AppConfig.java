package org.example;

import in.strikes.cartService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
// jha jha is component scan ko @component milega , uska object(bean) create krdega.......
public class AppConfig {
    @Bean
    public user createUser(){
        return new user("Aman",21);
    }

    @Bean
    public cartService addTOCart(){
        return new cartService();
    }
}
