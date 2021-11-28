package com.iain.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.iain.blog.domain.BaseBean;
import com.iain.blog.listener.Mains;
import com.iain.blog.result.Result;
import com.iain.blog.service.UserService;
import com.iain.blog.result.ResultFactory;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Classname UserController
 * @Description TODO
 * @Date 2020/9/2 12:10 上午
 * @Created by wht
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
//    @CrossOrigin 跨域问题前端处理
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Result getAllUser(){
        return ResultFactory.buildSuccessResult(userService.findAll());
    }

    @RequestMapping(value = "/testJson")
    public void testJson(){
        BaseBean baseBean = new BaseBean();
        baseBean.setCrtTm(new Date());
        String s = JSONObject.toJSONString(baseBean, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s);
    }

    @Autowired
    ApplicationEventPublisher publisher;

    @SneakyThrows
    @ResponseBody
    @RequestMapping("testCall")
    public String get() {
        //异步调用 异步监听器
//        System.out.println(Thread.currentThread().getName() +"controller");
//        publisher.publishEvent(new Mains("哈哈哈哈"));
//        return "123";
        System.out.println(Thread.currentThread().getName() +"controller");


        //异步调用 spring @Async
//        userService.testAnsyc();
        Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("sleep end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        //异步调用 callable
//        FutureTask<String> futureTask = new FutureTask<String>(() -> {
//
//            System.out.println(Thread.currentThread().getName() + " 进入call方法");
//            TimeUnit.SECONDS.sleep(5);
//            System.out.println("执行异步程序");
//            System.out.println(Thread.currentThread().getName() + " 从call方法返回");
//            return "aaa";
//        });
//        Thread thread = new Thread(futureTask);
//        thread.start();

        System.out.println(Thread.currentThread().getName() +"controller return");
        return "1";
    }

    @SneakyThrows
    @RequestMapping(value = "/testCall1")
    @ResponseBody
    public Callable<String> helloController() {
        System.out.println(Thread.currentThread().getName() + " 进入helloController方法");
        Callable<String> callable = () -> {

            System.out.println(Thread.currentThread().getName() + " 进入call方法");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("执行异步程序");
            System.out.println(Thread.currentThread().getName() + " 从helloService方法返回");
            return "aaa";
        };
        Callable<String> callable1 = () -> {

            System.out.println(Thread.currentThread().getName() + " 进入call方法");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("执行异步程序");
            System.out.println(Thread.currentThread().getName() + " 从helloService方法返回");
            return "bbb";
        };
        callable1.call();
        System.out.println(Thread.currentThread().getName() + " 从helloController方法返回");
        return callable;
    }

}
