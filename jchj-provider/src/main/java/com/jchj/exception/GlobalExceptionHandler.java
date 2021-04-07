package com.jchj.exception;


import com.jchj.bean.ResultInfo;
import com.jchj.constants.SysConstant;
import com.jchj.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * 异常拦截处理器
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    private static final String LOG_EXCEPTION_FORMAT = "Capture Exception By GlobalExceptionHandler: Code: %s Detail: %s";

    //token 无效
    /*@ExceptionHandler({PermissionException.class})
    public ResultInfo sessionError(PermissionException ex) {
        return resultFormat(999,ex,"token 无效");
    }*/

    //运行时异常
    @ExceptionHandler(RuntimeException.class)
    public ResultInfo runtimeExceptionHandler(RuntimeException ex) {
        return resultFormat(SysConstant.RUN_TIME_EXCEPTION_CODE, ex, SysConstant.RUN_TIME_EXCEPTION_MSG);
    }

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public ResultInfo nullPointerExceptionHandler(NullPointerException ex) {
        return resultFormat(1002, ex, "空指针异常");
    }

    //类型转换异常
    @ExceptionHandler(ClassCastException.class)
    public ResultInfo classCastExceptionHandler(ClassCastException ex) {
        return resultFormat(1003, ex, "类型转换异常");
    }

    //IO异常
    @ExceptionHandler(IOException.class)
    public ResultInfo iOExceptionHandler(IOException ex) {
        return resultFormat(1004, ex, "IO异常");
    }

    //未知方法异常
    @ExceptionHandler(NoSuchMethodException.class)
    public ResultInfo noSuchMethodExceptionHandler(NoSuchMethodException ex) {
        return resultFormat(1005, ex, "未知方法异常");
    }

    //数组越界异常
    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResultInfo indexOutOfBoundsExceptionHandler(IndexOutOfBoundsException ex) {
        return resultFormat(1006, ex, "数组越界异常");
    }

    //400错误
    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResultInfo requestNotReadable(HttpMessageNotReadableException ex) {
        log.info("400..requestNotReadable");
        return resultFormat(1007, ex, "400错误");
    }

    //400错误
    @ExceptionHandler({TypeMismatchException.class})
    public ResultInfo requestTypeMismatch(TypeMismatchException ex) {
        log.info("400..TypeMismatchException");
        return resultFormat(1008, ex, "400错误");
    }

    //400错误
    @ExceptionHandler({MissingServletRequestParameterException.class})
    public ResultInfo requestMissingServletRequest(MissingServletRequestParameterException ex) {
        log.info("400..MissingServletRequest");
        return resultFormat(1009, ex, "400错误");
    }

    //405错误
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResultInfo request405(HttpRequestMethodNotSupportedException ex) {
        return resultFormat(10, ex, "405错误");
    }

    //406错误
    @ExceptionHandler({HttpMediaTypeNotAcceptableException.class})
    public ResultInfo request406(HttpMediaTypeNotAcceptableException ex) {
        log.info("406...");
        return resultFormat(1011, ex, "406错误");
    }

    //500错误
    @ExceptionHandler({ConversionNotSupportedException.class, HttpMessageNotWritableException.class})
    public ResultInfo server500(RuntimeException ex) {
        log.info("500...");
        return resultFormat(1012, ex, "500错误");
    }

    //栈溢出
    @ExceptionHandler({StackOverflowError.class})
    public ResultInfo requestStackOverflow(StackOverflowError ex) {
        return resultFormat(1013, ex, "栈溢出");
    }

    //其他错误
    @ExceptionHandler({Exception.class})
    public ResultInfo exception(Exception ex) {
        return resultFormat(1014, ex, "其他错误");
    }


    private <T extends Throwable> ResultInfo resultFormat(Integer code, T ex, String exDesc) {
        ex.printStackTrace();
        log.error(String.format(LOG_EXCEPTION_FORMAT, code, ex.getMessage()));
        return ResultUtil.error(code, exDesc, ex.getMessage());
    }

}