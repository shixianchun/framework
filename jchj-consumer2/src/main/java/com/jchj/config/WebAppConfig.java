package com.jchj.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Sasuke
 * @Title: WebAppConfig
 * @Description: WebAppConfig
 * @ProjectName: rlt
 * @Date: 2020/3/13 11:05
 */
@Configuration
public class WebAppConfig implements WebMvcConfigurer {
	
//	@Bean
//	public UserRightInterceptor userRightInterceptor(){
//		return new UserRightInterceptor();
//	}
//
//    //拦截器，拦截文件流
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new FileHeaderCheckInterceptor())
//                .addPathPatterns("/**");
//
//       // registry.addInterceptor(userRightInterceptor()).addPathPatterns("/**");
//    }


}
