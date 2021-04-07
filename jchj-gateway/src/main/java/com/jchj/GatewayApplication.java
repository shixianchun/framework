package com.jchj;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.jchj")
@EnableFeignClients(basePackages = "com.jchj")
//@RibbonClients(value = {
//        @RibbonClient(name = "RLT-AUTHORIZE",configuration = ConfigLBRule.class)
//})
public class GatewayApplication {

    public static  void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
