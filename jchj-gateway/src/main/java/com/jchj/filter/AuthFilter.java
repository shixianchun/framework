package com.jchj.filter;


import com.jchj.exception.PermissionException;
import com.jchj.jwt.JwtConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

//@Component
public class AuthFilter implements  GlobalFilter {

	@Autowired
	private StringRedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    	Route gatewayUrl = exchange.getRequiredAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
    	URI uri = gatewayUrl.getUri();
    	ServerHttpRequest request = exchange.getRequest();
    	HttpHeaders header = request.getHeaders();
    	String token = header.getFirst(JwtUtil.HEADER_AUTH);
    	Map<String,String> userMap = JwtUtil.validateToken(token);
    	ServerHttpRequest.Builder mutate = request.mutate();
        /**
         * TODO
         * 方案1，把golbalfilter 改成 GatewayFilter 单独为公共接入创建路由
         * 方案2，先判断token类型，再拼接不同的缓存key 查询结果做处理， 类型1，用户。类型2，第三方app 准入。
         *       类型2的需要单独处理，在网关启动的时候将 类型2的数据从数据库导入到redis 中。并且在修改和新增时刷新缓存。
         *       类型1的数据在用户表中，类型2的数据在clientpermission 表中
         */


    	String key= JwtConstant.USER_TOKEN_PRIFIX+userMap.get("id");
		Long  expire =redisTemplate.getExpire(key);
		if(expire>0){
			if(expire <10){
				redisTemplate.expire(key,30, TimeUnit.MINUTES);
			}
			mutate.header(JwtConstant.HEADER_USER_ID, userMap.get("id"));
        	mutate.header(JwtConstant.HEADER_USER_NAME, userMap.get("user"));
        	mutate.header(JwtConstant.HEADER_SERVICENAME, uri.getHost());
		}else if("wxacc59b62e66ce0bf".equals(userMap.get("user"))){
			mutate.header(JwtConstant.HEADER_USER_ID, userMap.get("id"));
			mutate.header(JwtConstant.HEADER_USER_NAME, userMap.get("user"));
			mutate.header(JwtConstant.HEADER_SERVICENAME, uri.getHost());
		} else{
			throw new PermissionException("无效用户 token");
		}
//    	if(userMap.get("user").equals("admin") || userMap.get("user").equals("spring") || userMap.get("user").equals("cloud")) {
//
//    	}else {
//    		throw new PermissionException("user not exist, please check");
//    	}
    	ServerHttpRequest buildReuqest =  mutate.build();
    	return chain.filter(exchange.mutate().request(buildReuqest).build());
    }
}
