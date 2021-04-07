package com.jchj; /**
 * @author shixianchun
 * @Title: MysqlDataProvider
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/13:13 PM
 */


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shixianchun
 * @Title: MySqlDataProviderApp
 * @ProjectName microservice
 * @Description: TODO
 * @date 2019/9/25下午5:01
 */

@SpringBootApplication

@EnableDiscoveryClient
@EnableCircuitBreaker // 熔断
// @EnableApolloConfig
@MapperScan("com.jchj.mapper")
public class MysqlDataProvider {
    public static void main(String[] args) {
        SpringApplication.run(MysqlDataProvider.class, args);
    }

}
