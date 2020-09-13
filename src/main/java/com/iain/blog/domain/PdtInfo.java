package com.iain.blog.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Classname UserInfo
 * @Description 产品实体类
 * @Date 2020/8/16 4:02 下午
 * @Created by wht
 */
@Data
public class PdtInfo extends BaseBean implements Cloneable{
    private String pkId;
    private String pdtNam;
    private BigDecimal faceVal;
    public PdtInfo(){
        System.out.println("PdtInfo Constructor");
    }
    @Override
    public PdtInfo clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return (PdtInfo)clone;
    }

}
