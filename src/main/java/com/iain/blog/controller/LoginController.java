package com.iain.blog.controller;

import com.iain.blog.dto.LoginDto;
import com.iain.blog.result.Result;
import com.iain.blog.result.ResultFactory;
import com.iain.blog.service.PdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname pdtController
 * @Description TODO
 * @Date 2020/8/26 1:20 下午
 * @Created by wht
 */
@Controller
public class LoginController {
    @Autowired
    PdtService pdtService;
    //todo
    //@CrossOrigin  后端解决跨域问题
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(@RequestBody LoginDto loginDto) {
        return vaildLogin(loginDto) ? ResultFactory.buildSuccessResult(loginDto) : ResultFactory.buildFailResult("loginFail");
    }

    private boolean vaildLogin(LoginDto loginDto) {
        if ("admin".equals(loginDto.getUsername())) {
            return true;
        }
        return false;
    }
}
