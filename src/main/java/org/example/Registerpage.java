package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

@Test
public class Registerpage extends Utils {
    Loadprop loadprop=new Loadprop();
    private By _clickregister = By.className("ico-register");
    private By _clickfemale = By.id("gender-female");
    private  By _firstname = By.id("FirstName");
    private  By _lastname = By.id("LastName");
    private By _dateoftheday = By.name("DateOfBirthDay");
    private  By _dateofthemonth = By.name("DateOfBirthMonth");
    private By _dateoftheyear = By.name("DateOfBirthYear");
    private By _email= By.xpath("//input[@id=\"Email\"]");
    private By _password = By.name("Password");
    private By _confirmpassword = By.id("ConfirmPassword");
    private By _registerbutton = By.name("register-button");

    public void userIsOnRegisterPage() {
        clickOnElements(_clickregister);

        //verify user is on registration page
       String expectedurl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
       String atualurl = "https://demo.nopcommerce.com/register?returnUrl=%2F";
       Assert.assertEquals(atualurl, expectedurl);
    }
    public void userEnterDetailsForRegistration(){

        //click on female button
        clickOnElements(_clickfemale);
        //enter text in field firstname
        typeText(_firstname,loadprop.getProperty("Firstname"));
        //enter text in field lastname
        typeText(_lastname,loadprop.getProperty("lastname"));
        //select day on dateofbirth field
        selectByIndex(_dateoftheday,Integer.parseInt(loadprop.getProperty("Day")));
        //select month on dateofbirth field
        selectByVisibleText(_dateofthemonth,loadprop.getProperty("Month"));
        //select year of deatofbirth field
        selectByValue(_dateoftheyear,String.valueOf(loadprop.getProperty("Year")));
        //enter email
        typeText(_email,loadprop.getProperty("Emailpart1")+timeStamp()+loadprop.getProperty("Emailpart2"));
        //enter password
        typeText(_password,loadprop.getProperty("Password"));
        // enter confirm password
        typeText(_confirmpassword,loadprop.getProperty("confirmpassword"));
        //click on register button
        clickOnElements(_registerbutton);

    }

}
