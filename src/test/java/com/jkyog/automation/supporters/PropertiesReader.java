package com.jkyog.automation.supporters;

import com.jkyog.automation.customizedexceptions.FrameworkException;

import java.io.*;
import java.util.*;

public class PropertiesReader {

    private String filePath;
    private Properties properties;
    private FileInputStream fileInputStream;
    private String value;

    public PropertiesReader(String filePath) throws IOException {
        this.filePath = filePath;
        fileInputStream = new FileInputStream(filePath);
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getValue(String key) throws FrameworkException {
        if (properties != null) {
            value = properties.getProperty(key);
        } else {
            //throw exception
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
        return value;
    }

    public String getValue(String key, String defaultValue) throws FrameworkException {
        if (properties != null) {
            value = properties.getProperty(key);
            if (properties == null) {
                value = defaultValue;
            }
        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
        return value;
    }

    public String getValue(Object key) throws FrameworkException {
        if (properties != null) {
            value = (String) properties.get(key);
        } else {
            //throw exception
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
        return value;
    }

 /*   public String getValue(Object key, String defaultValue) throws FrameworkException {
        if (properties != null) {
            value = (String) properties.store((Writer) key, defaultValue);
            if (properties == null) {
                value = defaultValue;
            }
        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
        return value;
    }*/

    public String getValue(Object key, String defaultValue) throws FrameworkException {
        String value = defaultValue; // Initialize value with defaultValue

        if (properties != null) {
            // Use getProperty to get the value associated with the key
            String retrievedValue = properties.getProperty((String) key);

            if (retrievedValue != null) {
                value = retrievedValue; // If retrievedValue is not null, update the value
            }
        } else {
            // Throw an exception if properties is null
            throw new FrameworkException("Properties Object pointing to null");
        }

        return value;
    }

    public void writeKeyValue(String key, String value) throws IOException, FrameworkException {

        if (properties != null) {
            properties.setProperty(key, value);
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            properties.store(fileOutputStream, "File is saved successfully");
        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
    }

    public void writeKeyValue(Object key, Object value) throws IOException, FrameworkException {

        if (properties != null) {
            properties.put(key, value);
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            properties.store(fileOutputStream, "File is saved successfully");
        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
    }

    public Map<String, String> getKeysValues() throws FrameworkException {
        Map<String, String> map = new HashMap<String, String>();
        if (properties != null) {
            Set setKeys = properties.keySet();
            for (Object obj : setKeys) {
                String key = (String) obj;
                String value = properties.getProperty(key);
                map.put(key, value);
            }
        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
        return map;
    }

    public Set getKeys() throws FrameworkException {
        Set setKeys = null;
        if (properties != null) {
            setKeys = properties.keySet();

        } else {
            FrameworkException exception = new FrameworkException("Properties Object pointing to null");
            System.out.println("Properties Object pointing to null");
            throw exception;
        }
    return setKeys;
    }
    
    public List getValues() throws FrameworkException {
    List list = new ArrayList();
    if(properties!=null){
        Set setKeys =  properties.keySet();
        Iterator itr =setKeys.iterator();
        while (itr.hasNext()){
                Object obj =itr.next();
                list.add(obj);
        }
    }
    else {
        FrameworkException exception = new FrameworkException("Properties Object pointing to null");
        System.out.println("Properties Object pointing to null");
        throw exception;
    }

    return list;
    }
}
