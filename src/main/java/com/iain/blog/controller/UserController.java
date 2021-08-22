package com.iain.blog.controller;

import com.iain.blog.result.Result;
import com.iain.blog.service.UserService;
import com.iain.blog.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//    @CrossOrigin 跨域问题前端处理
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Result getAllUser(){
        return ResultFactory.buildSuccessResult(userService.findAll());
    }
}
