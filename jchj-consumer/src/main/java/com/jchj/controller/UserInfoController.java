package com.jchj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Maps;
import com.jchj.bean.ResultInfo;
import com.jchj.entity.UserInfo;
import com.jchj.service.mysqldata.userinfo.UserInfoClientService;
import com.jchj.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author shixianchun
 * @Title: UserInfoController
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/23:40 PM
 */
@Api(value = "/user", tags = "user")
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserInfoController {

    @Autowired
    private UserInfoClientService userInfoClientService;

    @ApiOperation(value = "用户_查询", notes = "根据ID查询")
    @RequestMapping(value = "/listUserInfoByPage", method = RequestMethod.GET)
    public ResultInfo<UserInfo> listUserInfoByPage(HttpServletRequest request,
                                                 @RequestParam int current, @RequestParam int size) {
        //String userid=JwtBaseUtil.getCurrentUserId(request);
        //String userName=JwtBaseUtil.getCurrentUserName(request);
        Map<String, Object> columnMap = Maps.newHashMap();
        Page<UserInfo> page =userInfoClientService.listUserInfoByPage(current,size);
        return ResultUtil.success(page);
    }

    @ApiOperation(value = "用户1", notes = "根据ID查询")
    @RequestMapping(value = "/listUserInfos", method = RequestMethod.GET)
    public ResultInfo<UserInfo> listUserInfos(HttpServletRequest request,@RequestBody Map<String, Object> columnMap,
                                                   @RequestParam int current, @RequestParam int size) {
        //String userid=JwtBaseUtil.getCurrentUserId(request);
        //String userName=JwtBaseUtil.getCurrentUserName(request);
//        Map<String, Object> columnMap = Maps.newHashMap();
        LoggerFactory.getLogger(UserInfoController.class).info("1111");
        Page<UserInfo> page =userInfoClientService.listUserInfos(columnMap,current,size);
        return ResultUtil.success(page);
    }

}
