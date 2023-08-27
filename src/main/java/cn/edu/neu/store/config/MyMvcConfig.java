package cn.edu.neu.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/user/register.html").setViewName("user/register");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/manager/board.html").setViewName("manager/board");
    }
    //解决上传图片未编译不显示问题,配置虚拟路径映射访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 映射图片保存地址
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:C:\\Users\\Administrator\\Desktop\\GameStore\\src\\main\\resources\\static\\images\\");
    }
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }

    //拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/login","/index.html","/","/user/getReg","/user/ToReg","/css/*","/js/**","/images/**","/login.html","/user/register.html");

    }
}