package com.cybertek.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    static Properties pro;

    static {
        String  path = "configurations.properties";

        try {
            FileInputStream file = new FileInputStream(path);
            pro = new Properties();
            pro.load(file);
            file.close();
        } catch (Exception e) {
            System.out.println("Path: " + path + " -not found.");
        }
    }

    //method to ake dynamic so that I cann call all keys with this method
    public static String getProperty(String key){

        return pro.getProperty(key);
    }

    public static void main(String[] args) {
        String s = pro.getProperty("name");
        System.out.println(s);
    }
}
