package com.iain.blog.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname BaseBean
 * @Description 数据库映射类基类
 * @Date 2020/8/16 3:57 下午
 * @Created by wht
 */
@Data
public class BaseBean {
//    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    @JSONField(format = "yyyy-MM")
    public Date crtTm;
    public Date uptTm;
    public String crtUsr;
    public String uptUsr;
    public BaseBean(){
        System.out.println("BaseBean Constructor");
    }

//    public static final Map filter = new HashMap(){{
//        filter.put("111","aaa");
//    }};
    public static final Map<String, String> BANK_TYPE = new HashMap<String, String>(){
        private static final long serialVersionUID = 1L;//可有可无
        {
            put("ZX", "中信银行");
            put("PN", "平安银行");
            put("CB", "中国银行");
        }
    };
}
