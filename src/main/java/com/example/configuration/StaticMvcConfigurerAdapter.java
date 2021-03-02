package com.example.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author yaoweixin
 * @date 2020/3/1-0:13
 */
@Configuration
public class StaticMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("img/**")//这个将应用到url中
                .addResourceLocations("file:E:/Pictures/img/");//这里填的是图片的绝对父路径
        super.addResourceHandlers(registry);
    }
}
