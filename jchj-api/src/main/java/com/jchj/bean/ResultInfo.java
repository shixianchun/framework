package com.jchj.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author Sasuke
 * @Title: ResultInfo
 * @Description: 返回信息
 * @ProjectName rlt
 * @Date 2020/2/17 11:07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer code;

    /**
     * 状态
     */
    private String state;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 引用
     */
    private String referer;

    /**
     * 返回数据
     */
    private T data;

    public ResultInfo() {
    }

    public ResultInfo(Integer code, String state, String msg, String referer, T data) {
        this.code = code;
        this.state = state;
        this.msg = msg;
        this.referer = referer;
        this.data = data;
    }
}
