package com.iain.blog.controller;

import com.iain.blog.result.Result;
import com.iain.blog.service.PdtService;
import com.iain.blog.service.impl.ExcelProcess;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Classname pdtController
 * @Description TODO
 * @Date 2020/8/26 1:20 下午
 * @Created by wht
 */
@RestController
public class PdtController {
    @Autowired
    PdtService pdtService;

    @RequestMapping("/findPdt")
    public void findAll() {
        pdtService.findAll();
    }


    //    @CrossOrigin  //后端解决跨域问题
    @PostMapping(value = "/upload")
    public Result ExcelInsertGoodinStore(@RequestParam("file") MultipartFile excelFile, HttpServletResponse response) {
        String name = excelFile.getOriginalFilename();
        ExcelProcess excelProcess = new ExcelProcess();
        int a = 1;
        Result result = new Result(10, "succ", "下载成功");
//        if (a == 1) {
//            result.setMessage("处理成功");
//            result.setData("aa22");
//            return result;
//        }
        try {
            Workbook workbook = excelProcess.run(excelFile);

            String fielName = "aaaawwwww.xlsx";
            response.setHeader("Content-type", "application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            //设置响应头部，以及文件名进行中文防止乱码转码操作
            response.setHeader("Content-Disposition", "attachment;filename=" + fielName);
            workbook.write(response.getOutputStream());
            workbook.close();
//            response.setStatus(201);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return null;
    }

}
