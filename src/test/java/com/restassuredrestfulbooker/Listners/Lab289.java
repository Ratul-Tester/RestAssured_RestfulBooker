package com.restassuredrestfulbooker.Listners;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListner289.class)
public class Lab289 {

    @Test(groups = "Smoke")
    public void testDemo1(){
        System.out.println("Demo1");
    }

    @Test(groups = "Smoke")
    public void testDemo2(){
        System.out.println("Demo2");
    }

    @AfterSuite
    public void testMain(){
        System.out.println("This is Main");
        System.out.println("Sending report to QA........");
    }
}
