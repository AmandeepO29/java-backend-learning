package in.strikes.filtersDemo.Configuration;

import in.strikes.filtersDemo.filters.DummyFilter;
import jakarta.servlet.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<DummyFilter> getDummyFilter(){
        FilterRegistrationBean<DummyFilter> registrationBean=new FilterRegistrationBean<>();

        registrationBean.setFilter(new DummyFilter());

        registrationBean.addUrlPatterns("/api/*");
        return registrationBean;
    }
}
