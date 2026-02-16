package com.restassuredrestfulbooker.Miscellaneous;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab287 {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                new Object[]{"Ratul", "Nandy"},
                new Object[]{"Pallob", "Das"},
                new Object[]{"Mampi", "Das"},
        };
    }

    @Test(dataProvider = "data")
    public void testDatas(String Name, String Title) {
        System.out.println("The Name is : " + Name);
        System.out.println("The Title is : " + Title);
    }
}
