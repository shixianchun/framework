package com.jchj.controller;


import com.alibaba.fastjson.JSONObject;
import com.jchj.bean.ResultInfo;
import com.jchj.entity.UserInfo;
import com.jchj.filter.JwtUtil;
import com.jchj.jwt.JwtConstant;
import com.jchj.service.mysqldata.userinfo.UserInfoClientService;
import com.jchj.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/authorize")
@CrossOrigin
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserInfoClientService userInfoClientService;

    @Autowired
    private StringRedisTemplate redisTemplate;
    



//    @RequestMapping(value = "/getSysUser", method = RequestMethod.GET)
//    public ResultInfo<UserInfo> getSysUser(@RequestParam String id) {
//        return ResultUtil.success(userInfoClientService.getSysUser(id));
//    }


//    /**
//     * 登录
//     * @param
//     * @return
//     */
//    @RequestMapping(value = "/signin", method = RequestMethod.POST)
//    public ResultInfo signIn(@RequestBody SysUser user) {
//        UserInfo sysUser =userInfoClientService.checkUser(user,user.getPassword());
//        if(null!= sysUser){
//            String key= JwtConstant.USER_KEY_PREFIX+ sysUser.getId();
//            redisTemplate.opsForValue().set(key, JSONObject.toJSONString(sysUser));
//            redisTemplate.expire(key,30,TimeUnit.MINUTES);
//            onSignIn(sysUser);
//            //缓存该用户的所有菜单
//        	saveUserMenu(sysUser);
//            return ResultUtil.success(sysUser);
//        }
//        return  ResultUtil.error("用户名或密码错误");
//    }

//    /**
//     * API 准入
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/apiauthorize", method = RequestMethod.POST)
//    public ResultInfo apiauthorize(@RequestBody SysUser user) {
//        SysUser sysUser =authorizeApiService.checkUser(user,user.getPassword());
//        if(null!= sysUser){
//            String userkey=JwtConstant.USER_KEY_PREFIX+ sysUser.getId();
//            redisTemplate.opsForValue().set(userkey, JSONObject.toJSONString(sysUser));
////            redisTemplate.expire(key,30,TimeUnit.MINUTES);
//            String token=JwtUtil.generateToken(sysUser);
//            String tokenkey = JwtConstant.USER_TOKEN_PRIFIX+sysUser.getId();
//            redisTemplate.opsForValue().set(tokenkey,token);
//            sysUser.setToken(token);
//            return ResultUtil.success(sysUser);
//        }
//        return  ResultUtil.error("用户名或密码错误");
//    }

    /**
//     * 注册
//     * @param id
//     * @return
//     */
//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    public ResultInfo<SysUser> signUp(@RequestParam String id) {
////        redisTemplate.opsForValue().set("ceshi","123");
//        return ResultUtil.success();
//    }

//    /**
//     * 登出
//     * @param user
//     * @return
//     */
//    @RequestMapping(value = "/signout", method = RequestMethod.POST)
//    public ResultInfo<SysUser> signOut(ServerWebExchange exchange, @RequestBody SysUser user) {
//
//        ServerHttpRequest request = exchange.getRequest();
//        HttpHeaders header = request.getHeaders();
//        String token = header.getFirst(JwtUtil.HEADER_AUTH);
//        onSignOut(token);
//        return ResultUtil.success();
//    }


//    private void onSignIn(SysUser user){
//        String token=JwtUtil.generateToken(user);
//        renewToken(token,user.getId());
//        user.setToken(token);
//    }

    private String renewToken(String token,String userId ){
        String key = JwtConstant.USER_TOKEN_PRIFIX+userId;
        redisTemplate.opsForValue().set(key,token);
        redisTemplate.expire(key,30, TimeUnit.MINUTES);
        return token;
    }

//    private SysUser getSignInUserByToken(String token){
//        Map<String,String> map=null;
//        try{
//            map= JwtUtil.validateToken(token);
//        }catch (Exception e){
//            throw new PermissionException("用户未登录");
//        }
//
//        String userName = map.get("user");
//        String userId = map.get("id");
//        Long expired = redisTemplate.getExpire(JwtConstant.USER_TOKEN_PRIFIX+userId);
//        if(expired > 0){
//            renewToken(token,userId);
//            SysUser user = authorizeApiService.getSysUser(userId);
//            user.setToken(token);
//            return user;
//        }else {
//            throw new PermissionException("未登录");
//
//        }
//
//    }

    private void onSignOut(String token){
        Map<String,String> map=JwtUtil.validateToken(token);
        String userId = map.get("id");
        redisTemplate.delete(JwtConstant.USER_TOKEN_PRIFIX+userId);
    }

//    /**
//     * 缓存用户的菜单
//     * @param user
//     */
//    public void saveUserMenu(SysUser user){
//    	//根据userid获取用户关联的所有角色下的菜单
//    	Map<String,Object> map=authorizeApiService.findSysMenuByUserId(user.getId());
//    	String userMenukey=JwtConstant.USERMENU_KEY_PREFIX+ user.getId();
//    	//将userId下的菜单放入缓存
//    	if (!CollectionUtils.isEmpty(map)) {
//    		redisTemplate.opsForValue().set(userMenukey, JSONObject.toJSONString(map));
//    	}
//    }

}