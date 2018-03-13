package com.epam.lab.utils.provider;

import com.epam.lab.utils.DataReader;
import org.testng.annotations.DataProvider;

public class TestProvider {
    @DataProvider
    public Object[][] getUsersData() {
        return new DataReader().getXLSAndCSVData();
    }
}
