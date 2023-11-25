package Mall_6_25.demo.mall.config;

import Mall_6_25.demo.mall.interceptor.Login_interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
//configure rule of interceptor
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
//        registry.addInterceptor(new Login_interceptor()).addPathPatterns("/*/admin/**");
//        registry.addInterceptor(new Login_interceptor()).addPathPatterns("/admin*");

    }
}
