package org.example;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FacebookPage extends Utils{
    private By _mosehover = By.className("html-home-page");
    private  By _clickonfacebook = By.xpath("//li[@class=\"facebook\"]");
// private By _click = By.className("class=\"l9j0dhe7 buofh1pr j83agx80 bp9cbjyn\"");

    public void userIsOnFacebookPage(){
        //user is on home page
        //scroll down the page
      moseHovering(_mosehover);
       //click on facebook
       clickOnElements(_clickonfacebook);
        //verify user is on facebook window
        String expectedurl = "https://www.facebook.com/nopCommerce";
       String actualurl = "https://www.facebook.com/nopCommerce";
        Assert.assertEquals(actualurl,expectedurl);
        //user is on homepage now
      windowHandle();
    }
}