package com.jchj.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jchj.entity.UserInfo;
import com.jchj.service.IUserInfoService;
import com.jchj.service.mysqldata.userinfo.UserInfoClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author shixianchun
 * @Title: UserInfoController
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/14:13 PM
 */
@Slf4j
@RestController
public class UserInfoController implements UserInfoClient {



    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IUserInfoService userInfoService;


    @Override
    public Page<UserInfo> listUserInfoByPage(Integer current, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        Page<UserInfo> page=userInfoService.page(new Page(current, size), queryWrapper);
        List<UserInfo> list=page.getRecords();
//        list.stream().forEach(e -> e.setOpenId(e.getOpenId().replace(e.getOpenId().substring(5,9), "****")));;
        return page.setRecords(list);
    }

    @Override
    public Page<UserInfo> listUserInfos(Map<String, Object> columnMap,Integer current, Integer size) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.orderByDesc("create_time");
        Page<UserInfo> page=userInfoService.page(new Page(current, size), queryWrapper);
        List<UserInfo> list=page.getRecords();
//        list.stream().forEach(e -> e.setOpenId(e.getOpenId().replace(e.getOpenId().substring(5,9), "****")));;
        return page.setRecords(list);
    }
}
