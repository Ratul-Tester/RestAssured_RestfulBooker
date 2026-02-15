package com.restassuredrestfulbooker.Miscellaneous;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab286 {

    @DataProvider
    public Object[][] DataInit(){
        return new Object[][]{
              new Object[]{"Rama","Chandra"},
              new Object[]{"Vama","Chandra"},
              new Object[]{"Shyama","Chandra"}
        };
    }

    @Test(dataProvider = "DataInit")
    public void getDataFrom(String UserName, String Password){
        System.out.println(UserName);
        System.out.println(Password);
    }
}
