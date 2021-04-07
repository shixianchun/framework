package com.jchj.utils;


import com.jchj.bean.ResultInfo;

/**
 * @Author Sasuke
 * @Title: ResultUtil
 * @Description: ResultUtil
 * @ProjectName rlt
 * @Date 2020/2/18 17:33
 */
public class ResultUtil {


    public static final Integer SUCCESS_CODE = 200;
    public static final String SUCCESS_STATE = "success";
    public static final String SUCCESS_MSG = "操作成功";

    public static final Integer ERROR_CODE = 1000;
    public static final String ERROR_STATE = "error";
    public static final String ERROR_MSG = "操作失败";


    /************ success ************/
    public static ResultInfo success() {
        return getResultInfo(SUCCESS_CODE, SUCCESS_STATE, SUCCESS_MSG, null, null);
    }

    public static ResultInfo success(Object data) {
        return getResultInfo(SUCCESS_CODE, SUCCESS_STATE, SUCCESS_MSG, null, data);
    }

    public static ResultInfo success(String msg, Object data) {
        return getResultInfo(SUCCESS_CODE, SUCCESS_STATE, msg, null, data);
    }

    /************ error ************/
    public static ResultInfo error() {
        return getResultInfo(ERROR_CODE, ERROR_STATE, ERROR_MSG, null, null);
    }

    public static ResultInfo error(String msg) {
        return getResultInfo(ERROR_CODE, ERROR_STATE, msg, null, null);
    }

    public static ResultInfo error(Integer code, String msg) {
        return getResultInfo(code, ERROR_STATE, msg, null, null);
    }

    public static ResultInfo error(Integer code, String state, String msg) {
        return getResultInfo(code, state, msg, null, null);
    }

    public static ResultInfo error(Integer code, String state, String msg, Object data) {
        return getResultInfo(code, state, msg, null, data);
    }

    public static ResultInfo getResultInfo(Integer code, String state, String msg, String referer, Object data) {
        ResultInfo resultInfo = new ResultInfo(code, state, msg, referer, data);
        return resultInfo;
    }

}
