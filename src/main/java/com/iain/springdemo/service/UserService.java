package com.iain.springdemo.service;

import com.iain.springdemo.domain.PdtInfo;
import com.iain.springdemo.domain.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/9/2 12:24 上午
 * @Created by wht
 */
public interface UserService {
    List<UserInfo> findByMap(Map<String,Object> args);
    List<UserInfo> findAll();
}
