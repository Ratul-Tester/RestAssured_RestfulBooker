package com.restassuredrestfulbooker.Miscellaneous;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab285a {

    @DataProvider
    public Object[][] RawData(){
        return new Object[][]{
          new Object[] {"Ratul","Nandy"},
          new Object[] {"Ruby","Nandy"},
          new Object[] {"Sunoyoni","Nandy"}
        };
    }

    @Test(dataProvider = "RawData")
    public void printData(String Firstname, String Lastname){
        System.out.println("The First Name is : "+Firstname);
        System.out.println("The Last Name is : "+Lastname);
    }
}
