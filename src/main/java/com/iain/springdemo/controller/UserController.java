package com.iain.springdemo.controller;

import com.iain.springdemo.result.Result;
import com.iain.springdemo.result.ResultFactory;
import com.iain.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/findAll", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllUser(){
        return ResultFactory.buildSuccessResult(userService.findAll());
    }
}
