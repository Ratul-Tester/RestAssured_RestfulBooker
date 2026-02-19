package com.restassuredrestfulbooker.Listners;

import org.testng.annotations.*;

@Listeners(CustomListner289a.class)
public class Lab289a {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("I will be displayed Before-Suite");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I will be displayed Before-Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("I will be displayed Before-Class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I will be displayed Before-Method");
    }

    @Test
    public void steps(){
        System.out.println("This is the Main Test Case and Execution Part");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I will be displayed After-Method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("I will be displayed After-Class");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("I will be displayed After-Test");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("I will be displayed After-Suite");
    }
}
