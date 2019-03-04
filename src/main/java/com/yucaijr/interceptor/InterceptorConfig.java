package com.yucaijr.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  
public class InterceptorConfig implements WebMvcConfigurer {

	 /**
     * 自己定义的登陆拦截器类
     * @return
     */
    @Bean
    CheckLoginInterceptor checkLoginInterceptor() {
        return new CheckLoginInterceptor();
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
        registry.addInterceptor(checkLoginInterceptor())
        		.addPathPatterns("/**")
        		.excludePathPatterns("/index.html")
        		.excludePathPatterns("/mobile/index.html")
        		.excludePathPatterns("/user/login")
        		.excludePathPatterns("/project/createProject")
        		.excludePathPatterns("/**/*.js")
        		.excludePathPatterns("/**/*.css")
        		.excludePathPatterns("/**/*.png")
        		.excludePathPatterns("/**/*.jpg");
        		
    }
}
