package com.iain.springdemo.controller;

import com.iain.springdemo.service.PdtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname pdtController
 * @Description TODO
 * @Date 2020/8/26 1:20 下午
 * @Created by wht
 */
@Controller
public class PdtController {
    @Autowired
    PdtService pdtService;

    @RequestMapping("/findPdt")
    public void findAll(){
        pdtService.findAll();
    }
}
