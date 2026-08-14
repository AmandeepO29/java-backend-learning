package in.strikes;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CartService implements InitializingBean, DisposableBean {
    Map<Integer,String>mp;
    public CartService() {
        mp=new HashMap<>();
        System.out.println("cart service constructor called");
    }

    // this callback is done after bean creation , dependency injection
    // and before calling any method like AddToCart()
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean is ready");
        mp.put(1,"Aman");
        mp.put(2,"Rahul");
    }

//    public void start1(){
//        System.out.println("Bean is ready");
//        mp.put(1,"Aman");
//        mp.put(2,"Rahul");
//    }
    @PostConstruct
    public void start2(){
        System.out.println("Bean is ready");
        mp.put(1,"Aman");
        mp.put(2,"Rahul");
    }
    public void AddToCart(){
        System.out.println("Added to cart");
    }
    public String getValue(int key){
        return mp.get(key);
    }

    @Override
    public void destroy() throws Exception {
        mp.clear();
        System.out.println("Bean is getting destroyed ");
    }
}
