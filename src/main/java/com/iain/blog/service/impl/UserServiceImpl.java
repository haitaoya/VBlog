package com.iain.blog.service.impl;

import com.iain.blog.domain.UserInfo;
import com.iain.blog.mapper.UserMapper;
import com.iain.blog.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2020/9/2 12:26 上午
 * @Created by wht
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserInfo> findByMap(Map<String, Object> args) {
        return userMapper.findByMap(args);
    }

    @Override
    public List<UserInfo> findAll() {
        return userMapper.findAll();
    }

    @Async
    @Override
    public void testAnsyc() throws InterruptedException, ExecutionException, TimeoutException {
        System.out.println(Thread.currentThread().getName() + "testAnsyc begin");

        FutureTask<String> futureTask = new FutureTask<String>(() -> {

            System.out.println(Thread.currentThread().getName() + "开始导出啦 ，预计15s");
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "导出结束 ，用时15s");

            return "aaa";
        });
        Thread thread = new Thread(futureTask);
        System.out.println(Thread.currentThread().getName() + "准备调用导出方法，5s内必须完成");
        thread.start();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = futureTask.get(5, TimeUnit.SECONDS);

        System.out.println(Thread.currentThread().getName() + "导出超时！！！！！！！！结束,准备抛异常 ");

        System.out.println(Thread.currentThread().getName() + "testAnsyc end");
    }


}
