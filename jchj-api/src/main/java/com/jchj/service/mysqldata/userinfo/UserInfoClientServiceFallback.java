package com.jchj.service.mysqldata.userinfo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jchj.entity.UserInfo;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

/**
 * @Author Sasuke
 * @Title: AppletClientServiceFallback
 * @Description: AppletClientServiceFallback
 * @ProjectName rlt
 * @Date 2020/2/13 21:24
 */
@Component
public class UserInfoClientServiceFallback implements FallbackFactory<UserInfoClientService> {
    @Override
    public UserInfoClientService create(Throwable throwable) {

        return new UserInfoClientService() {

            @Override
            public Page<UserInfo> listUserInfoByPage(Integer current, Integer size) {
                return null;
            }

            @Override
            public Page<UserInfo> listUserInfos(Map<String, Object> columnMap, Integer current, Integer size) {
                return null;
            }

        };
    }
}
