package in.strikes;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

//@Component
public class UserService implements BeanNameAware, ApplicationContextAware {
    public UserService(){
        System.out.println("User service constructor called");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is : "+name);
        // this prints userService as bean name....
        // the name of bean can't be changed if we call this method from main  by passing any name ,
        // that will only print on console , actual name will not change
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Application context class is : "+applicationContext.getClass());
    }
}
