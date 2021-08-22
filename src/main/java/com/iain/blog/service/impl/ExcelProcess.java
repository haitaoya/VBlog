package com.iain.blog.service.impl;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.Color;
import java.io.*;
import java.text.SimpleDateFormat;

public class ExcelProcess {
    public Workbook run(MultipartFile excelFile) throws IOException, InvalidFormatException {

//        ExcelTest3 excelTest3 = new ExcelTest3();
//        Workbook workbook = excelTest3.getExcel("/Users/wht/Pictures/aaaa.xls");
//        excelTest3.analyzeExcel(workbook);
        Workbook workbook = null;
        workbook = WorkbookFactory.create(excelFile.getInputStream());
        HSSFDataFormat df = (HSSFDataFormat) workbook.createDataFormat(); // 此处设置数据格式
        HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
//        style.setAlignment(HorizontalAlignment.CENTER); // 创建一个居中格式
        style.setFillForegroundColor(IndexedColors.RED.getIndex());// 设置背景色
        style.setDataFormat(df.getFormat("MM月dd日"));//
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //设置加粗
        //创建Workbook对象
//        Workbook workbook = new Workbook();

        //加载一个Excel文档
//        workbook.loadFromFile("C:\\Users\\Administrator\\IdeaProjects\\XLS\\sample.xlsx");

        //获取一个工作表
        Sheet sheet = workbook.getSheetAt(0);
        sheet.getRow(0).getCell(1).setCellStyle(style);
        sheet.getRow(1).getCell(2).setCellStyle(style);
//        FileOutputStream fileOut = new FileOutputStream(
//                "/Users/wht/Pictures/aaaa1.xls");
//        workbook.write(fileOut);
//        fileOut.close();
    //设置Header并且输出文件
        return workbook;

    }

    public Workbook getExcel(String filePath){
        Workbook wb=null;
        File file=new File(filePath);
        if(!file.exists()){
            System.out.println("文件不存在");
            wb=null;
        }
        else {
            String fileType=filePath.substring(filePath.lastIndexOf("."));//获得后缀名
            try {
                InputStream is = new FileInputStream(filePath);
                if(".xls".equals(fileType)){
                    wb = new HSSFWorkbook(is);
                }else if(".xlsx".equals(fileType)){
                    wb = new XSSFWorkbook(is);
                }else{
                    System.out.println("格式不正确");
                    wb=null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return wb;
    }

}