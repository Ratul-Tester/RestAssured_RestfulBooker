package com.restassuredrestfulbooker.Miscellaneous;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Lab288 {

    @DataProvider
    public Object[][] data(){
        return new Object[][]{
          new Object[]{"Ram","Chandra"},
          new Object[]{"Shiv","Sambhu"},
          new Object[]{"Nand","Gopal"},
          new Object[]{"Krishn","Kanaiha"}

        };
    }

    @Test(dataProvider = "data")
    public void getData(String Name, String Title){
        System.out.println("Name : "+Name);
        System.out.println("Title : "+Title);
    }
}
