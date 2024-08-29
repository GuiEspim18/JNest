package com.project.JNest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.project.JNest.DataNest.DataNest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JNest {

    public static DataNest read(String file) {
        try (FileInputStream fis = new FileInputStream(file); Workbook wk = new XSSFWorkbook(fis)) {
            Sheet sheet = wk.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            DataNest dataFrame = new DataNest();

            int rowCount = 0;
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                List<Object> rowData = new ArrayList<>();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                rowData.add(cell.getDateCellValue());
                            } else {
                                rowData.add(cell.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            rowData.add(cell.getBooleanCellValue());
                            break;
                        default:
                            rowData.add(null);
                            break;
                    }
                }

                if (rowCount == 0) {
                    dataFrame.setHeader(rowData);
                } else {
                    dataFrame.addRow(rowData);
                }
                rowCount++;
            }
            return dataFrame;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}