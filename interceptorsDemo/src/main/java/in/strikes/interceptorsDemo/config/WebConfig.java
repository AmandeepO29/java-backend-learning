package in.strikes.interceptorsDemo.config;


import in.strikes.interceptorsDemo.interceptor.AuthenticationInterceptor;
import in.strikes.interceptorsDemo.interceptor.AuthorizationInterceptor;
import in.strikes.interceptorsDemo.interceptor.LoggingInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public LoggingInterceptors loggingInterceptors;
    public AuthenticationInterceptor authenticationInterceptor;
    public AuthorizationInterceptor authorizationInterceptor;

    public WebConfig(LoggingInterceptors loggingInterceptors,
                     AuthenticationInterceptor authenticationInterceptor
                    ,AuthorizationInterceptor authorizationInterceptor){
        this.loggingInterceptors=loggingInterceptors;
        this.authenticationInterceptor=authenticationInterceptor;
        this.authorizationInterceptor=authorizationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login" ,"/api/public/**")
                        .order(1);

        registry.addInterceptor(loggingInterceptors)
                        .order(3);
        // since order is 3 . if any one of authorization , authentication interceptor fails
        // then it will not be executed... as it will return false..
        // no further interceptors will execute
        registry.addInterceptor(authorizationInterceptor)
                .order(2);
    }
    // /api/ -> exact match
    // /api/* ->request contains only one end point after /api
    // /api/** -> any number of nested end points

}
