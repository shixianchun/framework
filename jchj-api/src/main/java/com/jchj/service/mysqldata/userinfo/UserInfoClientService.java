package com.jchj.service.mysqldata.userinfo;


import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author Sasuke
 * @Title: AppletClientService
 * @Description: AppletClientService
 * @ProjectName rlt
 * @Date 2020/2/13 21:24
 */
@FeignClient(value = "jchj-mysqldata", fallbackFactory = UserInfoClientServiceFallback.class)
public interface UserInfoClientService extends UserInfoClient {

}
