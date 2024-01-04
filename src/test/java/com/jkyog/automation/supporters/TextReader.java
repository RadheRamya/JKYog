package com.jkyog.automation.supporters;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextReader {

    private String filePath;
    private File file;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private String value;

    public TextReader (String filePath) throws IOException {
        this.filePath = filePath;
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
    }

    public String getData() throws IOException {
        if(bufferedReader!=null){
            value = bufferedReader.readLine();
        }
        else {
            //throw exception
            System.out.println("BufferedReader pointing to Null");
        }
        return value;
    }

    public List<String> getTotalData() throws IOException {
        List<String> fileData = new ArrayList<String>();
        if(bufferedReader!=null){
            while (bufferedReader.ready()){
                value = bufferedReader.readLine();
                fileData.add(value);
            }
        }
        else {
            //throw exception
            System.out.println("BufferedReader pointing to Null");
        }
        return fileData;
    }

    public void writeData(String data) throws IOException {
        if (bufferedReader!=null){
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }
        else {
            //throw exception
            System.out.println("BufferedReader pointing to Null");
        }
    }

    public void writeData(int data) throws IOException {
        if (bufferedReader!=null){
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }
        else {
            //throw exception
            System.out.println("BufferedReader pointing to Null");
        }
    }









}
