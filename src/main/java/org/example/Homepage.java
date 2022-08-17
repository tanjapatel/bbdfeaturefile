package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homepage extends Utils{

    public void UserIsOnHomePage(){
        //verify user is on homepage
        String expectedurl="https://demo.nopcommerce.com/";
        String actualurl = "https://demo.nopcommerce.com/";
        Assert.assertEquals(actualurl,expectedurl,"if testcase is fail");
        //click on register button
    }

    public void clickOnCategoryPageLink(String categoryname ){
        clickOnElements(By.linkText(categoryname));

    }


}
