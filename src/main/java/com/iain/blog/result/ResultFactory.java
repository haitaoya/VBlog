package com.iain.blog.result;

/**
 * @Classname ResultFactory
 * @Description 响应结果生成工厂类
 * @Date 2020/8/30 10:57 下午
 * @Created by wht
 */
public class ResultFactory {
    public static Result buildSuccessResult(Object data) {
        return buildResult(ResultCode.SUCCESS, "成功", data);
    }

    public static Result buildFailResult(String message) {
        return buildResult(ResultCode.FAIL, message, null);
    }

    public static Result buildResult(ResultCode resultCode, String message, Object data) {
        return buildResult(resultCode.code, message, data);
    }

    public static Result buildResult(int resultCode, String message, Object data) {
        return new Result(resultCode, message, data);
    }
}
