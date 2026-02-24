package com.restassuredrestfulbooker.Miscellaneous;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab286a {

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
                new Object[]{"Radhe","Mohan"},
                new Object[]{"Radhe","Shyam"},
                new Object[]{"Radhe","Gobinda"}
        };
    }

    @Test(dataProvider = "data")
    public void getData(String firstname, String lastname){
        System.out.println("First Name is : "+firstname);
        System.out.println("Last Name is : "+lastname);
    }
}
