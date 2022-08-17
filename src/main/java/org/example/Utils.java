package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Utils extends BasePage {
    //write reusable methods
    //click action perform
    public static void clickOnElements(By by){
        driver.findElement(by).click();
    }
    // type text in fields
    public static void typeText(By by, String text){
        driver.findElement(by).sendKeys(text);
    }
    public static  void getTextFromElement(By by){
        driver.findElement(by).getText();
    }
    // explicit wait for elements clickable
    public static void waitsForElementsClickable(By by, int time){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    // explicit wait for enter text in fields
    public static void waitsForTextToBe(int time,By by, String text){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by,text));
    }
    //explicit wait for url to be
    public static void waitsForUrlToBe(int time, String url){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }
    //explicit wait for alert is present
    public static void waitsForAlertIsPresent(int time){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //explicit wait for title is
    public static void waitsForTileIs(int time,String text){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleIs(text));
    }
    // this method gives second in time for change email, take screenshot
    public static String timeStamp(){
        Date date =new Date();
        SimpleDateFormat  dateFormat= new SimpleDateFormat("YYYYMMddhhmmss");
        return dateFormat.format(date);
    }
    // Drop down method from select form visible text
    public static void selectByVisibleText(By by,String text) {
        Select select = new Select(driver.findElement(by));
        select.selectByVisibleText(text);
    }
    // Drop down method from select by value
    public static void selectByValue(By by,String value){
        Select select= new Select(driver.findElement(by));
        select.selectByValue(value);
    }
    //Drop down method from select by index
    public static void selectByIndex(By by,int index){
        Select select = new Select(driver.findElement(by));
        select.selectByIndex(index);
    }
    public static void takeSnapShot(String a) {
        //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        //Move image file to new destination
        File DestFile=new File("target/Screenshot");
        //Copy file at destination
        try {
            FileUtils.copyFile(SrcFile,new File("target/Screenshot\\"+a+timeStamp()+".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void moseHovering(By by) {
       Actions builder =new Actions(driver);
       Action mouseoverhome = builder.keyDown(driver.findElement(by),Keys.SHIFT).build();
       mouseoverhome.perform();

    }
    public static void windowHandle() {
        //To handle open single window
       // String windowhandle = driver.getWindowHandle();
        // To handle all new opened window.
        Set<String> windowhandles = driver.getWindowHandles();
        Iterator<String> iterator = windowhandles.iterator();
        String parentwindow = iterator.next();
        String childwindow = iterator.next();
        driver.switchTo().window(parentwindow);
        driver.switchTo().window(childwindow);
    }
@Test
    public static void findListOfElements(By by){
        List<WebElement> elements = driver.findElements(by);
        System.out.println("number of elements" +elements.size());
    }

    public static void verifyGetCurrentUrl(String url){
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }
}