package com.jchj.service.mysqldata.userinfo;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jchj.entity.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @Author Sasuke
 * @Title: Wechart
 * @Description: Wechart
 * @ProjectName rlt
 * @Date 2020/2/13 21:24
 */
@Api(value = "/data", tags = "data")
@RequestMapping(value = "/data")
public interface UserInfoClient {

    @ApiOperation(value = "扫码历史记录分页查询", notes = "根据map分页查询")
    @RequestMapping(value = "/listUserInfoByPage", method = RequestMethod.GET)
    Page<UserInfo> listUserInfoByPage(@RequestParam(value = "current") Integer current, @RequestParam(value = "size") Integer size);

    @ApiOperation(value = "扫码历史记录分页查询", notes = "根据map分页查询")
    @RequestMapping(value = "/listUserInfos", method = RequestMethod.POST)
    Page<UserInfo> listUserInfos(@RequestBody Map<String, Object> columnMap,@RequestParam(value = "current") Integer current, @RequestParam(value = "size") Integer size);


}
