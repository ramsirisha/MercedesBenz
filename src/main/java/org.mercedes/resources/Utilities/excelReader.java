package org.mercedes.resources.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excelReader {

    public static String getData(String ColumnName) throws EncryptedDocumentException, InvalidFormatException, IOException {
        String SheetName = "benzdata";
        File file = new File("src/main/java/org.mercedes/resources/testdata/data.xlsx");
        FileInputStream fi = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheet(SheetName);
        Row row = sheet.getRow(0);
        short lastcolumnused = row.getLastCellNum();

        int colnum = 0;
        for (int i = 0; i < lastcolumnused; i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
                colnum = i;
                break;
            }
        }
        row = sheet.getRow(1);
        Cell column = row.getCell(colnum);
        String CellValue = column.getStringCellValue();

        return CellValue;

    }
}
