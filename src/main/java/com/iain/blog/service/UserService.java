package com.iain.blog.service;

import com.iain.blog.domain.UserInfo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2020/9/2 12:24 上午
 * @Created by wht
 */
public interface UserService {
    List<UserInfo> findByMap(Map<String,Object> args);
    List<UserInfo> findAll();

    void testAnsyc() throws InterruptedException, ExecutionException, TimeoutException;
}
