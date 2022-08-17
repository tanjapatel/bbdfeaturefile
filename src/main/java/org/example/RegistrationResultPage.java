package org.example;

import org.openqa.selenium.By;
import org.testng.Assert;

public class RegistrationResultPage extends Utils {
    private By _getmessage = By.xpath("//div[@class=\"result\"]");

    public void userIsOnRegisterResultPage() {
        //user get message on "your registration completed"
        getTextFromElement(_getmessage);
        // verify user is get message "your registration completed"
        String expected ="Your registration completed";
        Assert.assertEquals("Your registration completed",expected);
    }
}