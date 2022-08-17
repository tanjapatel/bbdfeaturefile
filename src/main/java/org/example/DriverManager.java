package org.example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class DriverManager extends Utils{
    Loadprop loadprop = new Loadprop();
    DesiredCapabilities caps = new DesiredCapabilities();

   public final String USERNAME = loadprop.getProperty("bsUsername");
   public final String AUTOMATE_KEY = loadprop.getProperty("bsAccessKey");
   public final String BrowserStackURL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
   boolean browserstack = Boolean.parseBoolean(System.getProperty("cloud"));
   String browserName = System.getProperty("browser");

    public void openBrowser() {
        // open the browser
        //making decision cloud true or false
        //this will be run if cloud true (In cloud)
        if (browserstack) {
            System.out.println("running cloud");
            //applying conditional loop for different browser options
           if (browserName.equalsIgnoreCase("chrome")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("browserName", "Chrome");
                capabilities.setCapability("browserVersion", "latest");
                HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                browserstackOptions.put("os", "Windows");
                browserstackOptions.put("osVersion", "10");
                capabilities.setCapability("bstack:options", browserstackOptions);
            } else {
                System.out.println("Your browsername is wrong");
            }
            try {
                driver = new RemoteWebDriver(new URL(BrowserStackURL), caps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        } else {
            String browsername = "chrome";
            //this will be run if cloud false(locally)
            System.out.println("Running Locally.......");
            //write a condition for different browser
            if (browsername.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browsername.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            } else {
                System.out.println(" you have select wrong browser");

            }
        }
            //use the implicitly wait globally for each webpage
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            //webpage window maximized
            driver.manage().window().maximize();
            //type url and open the website
            driver.get("https://demo.nopcommerce.com/");

    }
    //close the browser method
        public void closeBrowser() {
            driver.quit();
        }


    }