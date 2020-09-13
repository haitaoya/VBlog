package com.iain.springdemo.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Classname BaseBean
 * @Description 数据库映射类基类
 * @Date 2020/8/16 3:57 下午
 * @Created by wht
 */
@Data
public class BaseBean {
    public Date crtTm;
    public Date uptTm;
    public String crtUsr;
    public String uptUsr;
    public BaseBean(){
        System.out.println("BaseBean Constructor");
    }
}
