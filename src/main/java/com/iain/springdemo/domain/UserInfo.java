package com.iain.springdemo.domain;

import lombok.Data;


/**
 * @Classname UserInfo
 * @Description TODO
 * @Date 2020/9/2 12:12 上午
 * @Created by wht
 */
@Data
public class UserInfo extends BaseBean{

    private String pkId;
    private String userNam;
    private String passWord;
    private String telNo;
    //备注
    private String rem;
    private String sex;
    //账户状态 0失效/1生效
    private char isVaild;

}
