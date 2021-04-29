package com.nan.batch.utils;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XLSXReader {

    public List<List<String>> xlsxReader(String excelPath){

        List<List<String>> students = new ArrayList<>();
        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);

            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                Workbook wb = new XSSFWorkbook(excel);
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum()+1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();

                for(int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    Row row = sheet.getRow(rIndex);
                    List<String> student = new ArrayList<>();
                    if (row != null) {
                        int firstCellIndex = row.getFirstCellNum();
                        int lastCellIndex = row.getLastCellNum();
                        if(row.getCell(firstCellIndex).toString().trim().equals(""))
                            break;
                        for (int cIndex = firstCellIndex; cIndex < lastCellIndex; cIndex++) {   //遍历列
                            Cell cell = row.getCell(cIndex);
                            if (cell == null || cell.toString().equals("")) {
                                break;
                            }else student.add(cell.toString());

                        }

                        students.add(student);
                    }
                }
                wb.close();
            } else {
                System.out.println("找不到指定的文件");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }

        return students;
    }


}
