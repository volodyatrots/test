package com.epam.lab.businessobjects;

import com.epam.lab.models.UserModel;
import com.epam.lab.pageobjects.GmailInboxPage;
import com.epam.lab.pageobjects.GmailLoginPage;
import org.apache.log4j.Logger;

public class GmailLoginBO {
    private static final Logger LOG = Logger.getLogger(GmailLoginBO.class);
    private GmailInboxPage gmailInboxPage;
    private GmailLoginPage gmailLoginPage;

    public GmailLoginBO() {
        gmailLoginPage = new GmailLoginPage();
        gmailInboxPage = new GmailInboxPage();
    }

    public void openLoginPage() {
        LOG.info("Opening Login Page");
        gmailLoginPage.openLoginPage();
    }


    public void loginAS(UserModel userModel) {
        LOG.info("Entering Mail and Password");
        gmailLoginPage.enterEmail(userModel.getEmail());
        gmailLoginPage.enterPassword(userModel.getPassword());
    }

    public boolean checkLoginSuccess() {
        LOG.info("Check IF Login was Success");
        return gmailInboxPage.checkLoadInbox();
    }
}
