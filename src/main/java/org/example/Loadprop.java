package org.example;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Loadprop {
    static Properties prop;
    static FileInputStream input;
    static String filename = "testcongig.properties";
    static String fileLocation = "src/test/java/TestData/testconfig.properties";

    public String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream(fileLocation);
            prop.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

      return prop.getProperty(key);
    }
    @Test
  public void getlodprop(){
        System.out.println(getProperty("url"));

  }

}
