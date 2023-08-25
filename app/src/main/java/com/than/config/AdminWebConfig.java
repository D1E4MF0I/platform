package com.than.config;

import com.than.interceptor.JWTInterceptor;
import jakarta.annotation.Resource;
import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    @Resource
    private JWTInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/user/manage/**", "/user_msg/personal", "/user/login_cookie")
                .addPathPatterns("/post/personal/**", "/file/**", "/comment/own/**", "/axis/own/**", "/axis/family/**");
    }

    /**
     * 图片虚拟地址映射
     *
     * @param registry 设置该映射之后，外网只能访问本地的images文件内部的资源
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/file/**")
                .addResourceLocations("file:" + System.getProperty("user.dir") + "/home/docker/file/");
    }
}