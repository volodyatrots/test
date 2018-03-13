package com.epam.lab.utils.xlsx;

import com.epam.lab.models.UserModel;
import com.epam.lab.utils.property.ConfigProperty;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XLSXReader {
    public List<UserModel> getUsers() {
        try {
            ConfigProperty configProperty = new ConfigProperty();
            File excel = new File(configProperty.getPathXLSXUsers());
            FileInputStream fileInputStream = new FileInputStream(excel);
            XSSFWorkbook book = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = book.getSheetAt(0);
            List<UserModel> users = new ArrayList<>();
            for (int rowNum = sheet.getFirstRowNum() + 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                UserModel user = new UserModel();
                XSSFRow row = sheet.getRow(rowNum);
                for (int cellNum = row.getFirstCellNum(); cellNum <= row.getLastCellNum(); cellNum++) {
                    Cell currentCell = row.getCell(cellNum);
                    if (cellNum == 0) {
                        user.setEmail(currentCell.getStringCellValue());
                    } else if (cellNum == 1) {
                        user.setPassword(currentCell.getStringCellValue());
                    }
                }
                users.add(user);
            }
            fileInputStream.close();
            book.close();
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
