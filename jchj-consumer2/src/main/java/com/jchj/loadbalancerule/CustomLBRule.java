package com.jchj.loadbalancerule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

/**
 * @author shixianchun
 * @Title: CustomLBRule
 * @ProjectName microservice
 * @Description: 自定义负载均衡算法，实现后替换原配置。本处省略。
 * @date 2019/9/29下午4:54
 */
public class CustomLBRule extends AbstractLoadBalancerRule {
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        return null;
    }
}
