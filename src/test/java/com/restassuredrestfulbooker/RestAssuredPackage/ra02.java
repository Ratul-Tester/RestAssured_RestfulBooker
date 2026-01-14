package com.restassuredrestfulbooker.RestAssuredPackage;

import org.testng.annotations.*;

public class ra02 {

    @BeforeSuite
    void demo1(){
        System.out.println("Before Suite");
    }
    @BeforeClass
    void demo2(){
        System.out.println("Before Class");
    }
    @BeforeTest
    void demo3(){
        System.out.println("Before Test");
    }
    @BeforeMethod
    void demo4(){
        System.out.println("Before Method");
    }
    @Test
    void demo5(){
        System.out.println("This is Test");
    }
    @AfterMethod
    void demo6(){
        System.out.println("After Method");
    }
    @AfterTest
    void demo7(){
        System.out.println("After Test");
    }
    @AfterClass
    void demo8(){
        System.out.println("After Class");
    }
    @AfterSuite
    void demo9(){
        System.out.println("After Suite");
    }
}
