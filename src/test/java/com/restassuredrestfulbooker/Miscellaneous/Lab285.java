package com.restassuredrestfulbooker.Miscellaneous;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285 {

    @DataProvider
    public Object[][] givenData() {
        return new Object[][]{
                new Object[]{"Ratul", "Nandy"},
                new Object[]{"Sunoyoni", "Nandy"},
                new Object[]{"Saimoni", "Nandy"}
        };
    }


    @Test(dataProvider = "givenData")
    public void testData(String Username, String Password) {
        System.out.println("The User Name is : " + Username);
        System.out.println("The Password is : " + Password);
    }
}
