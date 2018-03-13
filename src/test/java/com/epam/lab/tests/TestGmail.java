package com.epam.lab.tests;

import com.epam.lab.businessobjects.GmailLoginBO;
import com.epam.lab.businessobjects.MessagesBO;
import com.epam.lab.driver.Driver;
import com.epam.lab.models.MessageModel;
import com.epam.lab.models.UserModel;
import com.epam.lab.utils.provider.TestProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestGmail {

    @Test(dataProvider = "getUsersData", dataProviderClass = TestProvider.class)
    public void sendFromDrafts(UserModel userModel, MessageModel message) {

        GmailLoginBO gmailLoginBO = new GmailLoginBO();

        gmailLoginBO.openLoginPage();

        gmailLoginBO.loginAS(userModel);

        assertTrue(gmailLoginBO.checkLoginSuccess());

        MessagesBO messagesBO = new MessagesBO();

        messagesBO.writeLetter(message);

        messagesBO.openDrafts();

        assertTrue(messagesBO.checkLoadDrafts());

        messagesBO.openMyLetter();

        messagesBO.sendLetter();

        assertTrue(messagesBO.checkSentMessage());
    }

    @AfterMethod
    public void closeDriver() {
        Driver.close();
    }
}