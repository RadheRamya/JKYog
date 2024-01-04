package com.jkyog.automation.utilities;

import com.jkyog.automation.supporters.ExcelReader;
import com.jkyog.automation.supporters.PropertiesReader;
import com.jkyog.automation.supporters.TextReader;

import java.io.IOException;

public class PojoReader
{
    public static PropertiesReader getConfPr() throws IOException {
        PropertiesReader prConf = new PropertiesReader(FilePaths.confPath);
        return prConf;
     }

    public static PropertiesReader getOrPr() throws IOException {
        PropertiesReader prOr = new PropertiesReader(FilePaths.orPath);
        return prOr;
    }

    public static ExcelReader getExcelReader() throws IOException {
        ExcelReader excelReader = new ExcelReader(FilePaths.excelPath);
        return excelReader;
    }

    public static TextReader getTextReader() throws IOException {
        TextReader textReader = new TextReader(FilePaths.txtPath);
        return textReader;
    }
}
