package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

public class NikeContainPage extends Utils {
    Loadprop loadprop = new Loadprop();
    private By _entertext =By.id("small-searchterms");
    private By _clicksearch = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private By _listofelemnte = By.xpath("//a[@href=\"/\"]");


    public void userIsOnNikeWordContainPage(){
        //user is on home page
        //enter nike word in search button
        typeText(_entertext,loadprop.getProperty("Entertext"));
        // click search button
        clickOnElements(_clicksearch);
        String expectedurl ="https://demo.nopcommerce.com/search?q=Nike";
        String actualurl ="https://demo.nopcommerce.com/search?q=Nike";
        Assert.assertEquals(actualurl,expectedurl);
        findListOfElements(_listofelemnte);


    }

}
