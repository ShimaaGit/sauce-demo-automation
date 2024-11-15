package com.saucedemo.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    Properties properties = new Properties();

    public ConfigReader() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
                    properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUrl(String key) {
        return properties.getProperty(key);
    }
}