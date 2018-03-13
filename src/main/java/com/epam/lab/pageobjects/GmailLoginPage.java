package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.TextInput;
import com.epam.lab.driver.Driver;
import com.epam.lab.utils.property.ConfigProperty;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class GmailLoginPage extends PageObject {
    @FindBy(css = "input[type='email']")
    private TextInput emailInput;

    @FindBy(css = "input[name='password']")
    private TextInput passwordInput;


    public void openLoginPage() {
        ConfigProperty configProperty = new ConfigProperty();
        Driver.getDriver().get(configProperty.getGmailLink());
    }

    public void enterEmail(String mail) {
        emailInput.sendKeys(mail + Keys.ENTER);
    }

    public void enterPassword(String pass) {
        passwordInput.sendKeys(pass + Keys.ENTER);
    }
}
