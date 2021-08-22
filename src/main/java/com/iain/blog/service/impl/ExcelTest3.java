package com.iain.blog.service.impl;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ExcelTest3 {

    public static void main(String[] args) {

        ExcelTest3 excelTest3 = new ExcelTest3();
        Workbook workbook = excelTest3.getExcel("/Users/wht/Pictures/aaaa.xls");
        excelTest3.analyzeExcel(workbook);

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

    public void analyzeExcel(Workbook wb){
        Sheet sheet=wb.getSheetAt(0);//读取sheet(从0计数)
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        for(int i=0;i<=rowNum;i++){
            Row row=sheet.getRow(i);//获得行
            int colNum=row.getLastCellNum();//获得当前行的列数
            for(int j=0;j<colNum;j++){
                Cell cell=row.getCell(j);//获取单元格
                CellStyle cellStyle = cell.getCellStyle();
                // xls 03版
                HSSFColor hssfColor = (HSSFColor) cellStyle.getFillForegroundColorColor();
                String color = hssfColor.getHexString();
                System.out.println(color);
                // xlsx 07版
//                XSSFColor xssfColor = (XSSFColor) cellStyle.getFillForegroundColorColor();
//                byte[] bytes = xssfColor.getRGB();
//                for (int k = 0; k < bytes.length; k++) {
//                    System.out.print(bytes[k] + "-");
//                }
                System.out.println();

            }

        }
    }
}
