package com.epam.lab.pageobjects;


import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DraftsPage extends PageObject {

    @FindBy(xpath = "//div[@class='aim'][3]")
    private Button draftsButton;

    @FindBy(xpath = "//input[@name='q']")
    private TextInput searchInput;

    @FindBy(xpath = "//span[contains(text(),'Hi!')]")
    private Button myLetter;


    public void openDrafts() {
        draftsButton.click();
    }


    public boolean checkLoadDrafts() {
        return new WebDriverWait(Driver.getDriver(), 60).until(ExpectedConditions.textToBePresentInElementValue(searchInput, "in:draft "));
    }

    public void openMyLetter() {
        myLetter.click();
    }
}
