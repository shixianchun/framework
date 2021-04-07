package com.jchj.loadbalancerule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shixianchun
 * @Title: CustomLBRule
 * @ProjectName microservice
 * @Description: TODO
 * @date 2019/9/29下午4:27
 */
@Configuration
public class ConfigLBRule {


    /**
     *  RoundRobinRule              轮询
     *  RandomRule                  随机
     *  AvailabilityFilteringRule   去掉多次访问故障导致熔断 和 并发超过阀值的服务，剩下的轮询
     *  WeightedResponseTimeRule    根据平均响应时间计算服务权重，响应快的权重大，权重大的选中几率高，初始化状态下用RoundRobinRule 收集信息，之后会切换
     *  RetryRule                   用RoundRobinRule策略，出错时在指定时间内重试
     *  BestAvailableRule           先过滤多次访问故障的，再选一个并发量最小的
     *  ZoneAvoidanceRule           复合判断性能和可用性
     *
     */
    @Bean
    public IRule configRule(){
        return new RandomRule();
    }
}
