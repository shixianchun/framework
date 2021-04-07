package com.jchj;

import com.jchj.loadbalancerule.ConfigLBRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shixianchun
 * @Title: RestfulApp
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/23:23 PM
 */
@SpringBootApplication(scanBasePackages = "com.jchj")
@EnableDiscoveryClient
@RibbonClients(value = {
        @RibbonClient(name = "jchj-mysqldata")
})

@EnableFeignClients(basePackages = "com.jchj")
@EnableCircuitBreaker // 熔断
public class RestfulApp {

    public static void main(String[] args) {
        SpringApplication.run(RestfulApp.class, args);
    }

}

