package com.jchj.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author shixianchun
 * @Title: Userinfo
 * @ProjectName framework
 * @Description: TODO
 * @date 2021/4/13:39 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String userName;




}
