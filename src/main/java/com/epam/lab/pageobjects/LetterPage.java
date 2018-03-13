package com.epam.lab.pageobjects;

import com.epam.lab.control.elements.Button;
import com.epam.lab.control.elements.TextInput;
import com.epam.lab.driver.Driver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LetterPage extends PageObject {
    private Boolean ifSentMessage;

    @FindBy(xpath = "//textarea[@name='to']")
    private TextInput mailToInput;

    @FindBy(css = (".vh"))
    private Button labelSentMessage;

    @FindBy(css = ".aoT")
    private TextInput mailSubjectInput;

    @FindBy(css = "div[class='Am Al editable LW-avf']")
    private TextInput mailMessageInput;

    @FindBy(css = ".Ha")
    private Button closeButton;

    @FindBy(css = "td[class='gU Up']")
    private Button sendButton;


    public void enterEmailTo(String mailTo) {
        mailToInput.sendKeys(mailTo);
    }

    public void enterEmailSubject(String mailSubject) {
        mailSubjectInput.sendKeys(mailSubject);
    }

    public void enterMessage(String mailMessage) {
        mailMessageInput.sendKeys(mailMessage);
    }

    public void closeLetter() {
        closeButton.click();
    }

    public void sendLetter() {
        sendButton.click();
    }

    public boolean checkSentMessage() {
        if ((new WebDriverWait(Driver.getDriver(), 60)).until(ExpectedConditions.elementToBeClickable(labelSentMessage)) != null) {
            ifSentMessage = true;
        }
        return ifSentMessage;
    }

}
