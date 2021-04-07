package com.jchj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jchj.entity.UserInfo;
import com.jchj.mapper.UserInfoMapper;
import com.jchj.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * @author shixianchun
 * @Title: UserInfoService
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/14:12 PM
 */
@Service
public class UserInfoService extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
