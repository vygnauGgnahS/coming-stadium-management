package com.situ.stadium.config;

import com.situ.stadium.commen.JwtInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfig implements WebMvcConfigurer {
    @Value("${upload.file.location}")
    private String fileLocation;
    @Value("${upload.file.path}")
    private String filePath;

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //注册配置类，使用addResourceHandler方法，将本地路径fileLocation映射到filePath路由上
        registry.addResourceHandler(filePath)
                .addResourceLocations("file:" + fileLocation);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor(jwtSecretKey))
                .addPathPatterns("/api/v1/**")
                .excludePathPatterns("/api/v1/login/**")
                .excludePathPatterns("/api/v1/logout/**")
                .excludePathPatterns("/api/v1/login/captcha/**")
                .excludePathPatterns("/api/v2/**");
    }
}
