package com.epam.lab.pageobjects;


import com.epam.lab.control.CustomFieldDecorator;
import com.epam.lab.driver.Driver;

import com.epam.lab.utils.property.ConfigProperty;
import org.openqa.selenium.support.PageFactory;

class PageObject {

    PageObject() {
        ConfigProperty configProperty = new ConfigProperty();
        System.setProperty(configProperty.getChromeDriver(), configProperty.getUrl());
        PageFactory.initElements(new CustomFieldDecorator(Driver.getDriver()), this);
    }
}
