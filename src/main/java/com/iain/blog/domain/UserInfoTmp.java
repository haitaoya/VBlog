package com.iain.blog.domain;

import lombok.Data;


/**
 * @Classname UserInfo
 * @Description TODO
 * @Date 2020/9/2 12:12 上午
 * @Created by wht
 */
//@Data
public class UserInfoTmp {

    private String pkId;
    private String userNam;
    private String passWord;
    private String telNo;

    public String getPkId() {
        return pkId;
    }

    public void setPkId(String pkId) {
        this.pkId = pkId;
    }

    public String getUserNam() {
        return userNam;
    }

    public void setUserNam(String userNam) {
        this.userNam = userNam;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getRem() {
        return rem;
    }

    public void setRem(String rem) {
        this.rem = rem;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public char getIsVaild() {
        return isVaild;
    }

    public void setIsVaild(char isVaild) {
        this.isVaild = isVaild;
    }

    //备注
    private String rem;
    private String sex;
    //账户状态 0失效/1生效
    private char isVaild;

}
