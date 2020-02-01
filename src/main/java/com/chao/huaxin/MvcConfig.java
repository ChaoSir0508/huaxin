package com.chao.huaxin;

import com.chao.huaxin.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class MvcConfig {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**").
                        excludePathPatterns(Arrays.asList("/admin/login","/admin","/css/**"));
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("admin/info").setViewName("admin/info");
                registry.addViewController("/admin").setViewName("admin/admin");
                registry.addViewController("/system").setViewName("system");
            }

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
            }
        };
    }

}
