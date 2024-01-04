package com.jkyog.automation.supporters;

import com.jkyog.automation.customizedexceptions.FrameworkException;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExcelReader {

    private String filePath;
    private FileInputStream fileInputStream;
    private Workbook workbook;
    private Sheet sheet;
    private Row row;
    private Cell cell;
    private String cellValue;

    public ExcelReader(String filePath) throws IOException {
        this.filePath = filePath;
        fileInputStream = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\JKYog\\src\\test\\java\\com\\jkyog\\automation\\testdata\\JKYog_TestData1.xlsx");
        workbook = WorkbookFactory.create(fileInputStream);
    }

    public Sheet getSheetObj(String how, String howvalue) throws FrameworkException {
        if (workbook != null) {
            if (how.equalsIgnoreCase("sheetName")) {
                sheet = workbook.getSheet(howvalue);
            } else if (how.equalsIgnoreCase("index")) {
                int ind = Integer.parseInt(howvalue);
                sheet = workbook.getSheetAt(ind);
            }
        } else {
            //throw exception
            FrameworkException exception = new FrameworkException("Workbook pointing to null");
            System.out.println("Workbook pointing to null");
            throw exception;
        }
        return sheet;
    }

    public String getCellData(String how, String howValue, int rowNum, int cellNum) throws FrameworkException {
        sheet = getSheetObj(how, howValue);
        if (sheet != null) {
            row = sheet.getRow(rowNum);
            if (row != null) {
                cell = row.getCell(cellNum);
                if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue() + "";
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    cellValue = cell.getNumericCellValue() + "";
                } else if (cell.getCellType() == CellType.BOOLEAN) {
                    cellValue = cell.getBooleanCellValue() + "";
                }
            } else {
                FrameworkException exception = new FrameworkException("Row is pointing to null");
                System.out.println("Row is pointing to null");
                throw exception;
            }
        } else {
            FrameworkException exception = new FrameworkException("Sheet is pointing to null");
            System.out.println("Sheet pointing to null");
            throw exception;
        }
        return cellValue;
    }

    public int getRowCount(String how, String howValue) throws FrameworkException {
        int rowsCount = 0;
        sheet = getSheetObj(how, howValue);
        if (sheet != null) {
            rowsCount = sheet.getLastRowNum();
        } else {
            FrameworkException exception = new FrameworkException("Sheet is pointing to null");
            System.out.println("Sheet is pointing to null");
            throw exception;
        }
        return rowsCount;
    }

    public int getCellCount(String how, String howValue, int rowNum, int cellNum) throws FrameworkException {
        int cellCount = 0;
        sheet = getSheetObj(how, howValue);
        if (sheet != null) {
            row = sheet.getRow(rowNum);
            if (row != null) {
                cellCount = row.getLastCellNum();
            } else {
                FrameworkException exception = new FrameworkException("Row is pointing to null");
                System.out.println("Row is pointing to null");
                throw exception;
            }
        } else {
            FrameworkException exception = new FrameworkException("Sheet is pointing to null");
            System.out.println("Sheet is pointing to null");
            throw exception;
        }
        return cellCount;
    }

    public List<String> getRowData(String how, String howValue, int rowNum) throws FrameworkException {
        List<String> rowData = new ArrayList<String>();
        sheet = getSheetObj(how, howValue);
        if (sheet != null) {
            row = sheet.getRow(rowNum);
            System.out.println("Row value is " + row);
            if (row != null) {
                for (int i = 1; i <= row.getLastCellNum(); i++) {
                    cell = row.getCell(i);
                    if (cell.getCellType() == CellType.STRING) {
                        cellValue = cell.getStringCellValue();
                    } else if (cell.getCellType() == CellType.NUMERIC) {
                        cellValue = cell.getNumericCellValue() + "";
                    } else if (cell.getCellType() == CellType.BOOLEAN) {
                        cellValue = cell.getBooleanCellValue() + "";
                    }
                    rowData.add(cellValue);
                }
            } else {
                FrameworkException exception = new FrameworkException("Row is pointing to null");
                System.out.println("Row is pointing to null");
                throw exception;
            }
        } else {
            FrameworkException exception = new FrameworkException("Sheet is pointing to null");
            System.out.println("Sheet is pointing to null");
            throw exception;
        }
        return rowData;
    }

    public List<String> getSheetData(String how, String howValue) throws FrameworkException {
        List<String> sheetData = new ArrayList<String>();
        sheet = getSheetObj(how, howValue);
        if (sheet != null) {
            for (int j = 1; j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row != null) {
                    for (int i = 0; i < row.getLastCellNum(); i++) {
                        cell = row.getCell(i);
                        if (cell != null) {
                            if (cell.getCellType() == CellType.STRING) {
                                cellValue = cell.getStringCellValue();
                            } else if (cell.getCellType() == CellType.NUMERIC) {
                                cellValue = String.valueOf(cell.getNumericCellValue());
                            } else if (cell.getCellType() == CellType.BOOLEAN) {
                                cellValue = String.valueOf(cell.getBooleanCellValue());
                            }
                            sheetData.add(cellValue);
                        } else{
                        FrameworkException exception = new FrameworkException("Row is pointing to null");
                        System.out.println("Row is pointing to null");
                        throw exception;

                    }
                }

                }
              }
            }

        else{
                FrameworkException exception = new FrameworkException("Sheet is pointing to null");
                System.out.println("Sheet is pointing to null");
                throw exception;
            }

        return sheetData;
    }


    public Set<String> getSheetUniqueData(String how, String howValue) throws FrameworkException {
        List<String> listSheetData = getSheetData(how, howValue);
        Set<String> setSheetData = new HashSet<String>();
        return setSheetData;
    }
}
