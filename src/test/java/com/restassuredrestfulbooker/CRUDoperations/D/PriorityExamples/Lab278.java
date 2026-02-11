package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Test;

public class Lab278 {

    @Test(priority = 1)
    public void testMethodOne(){
        System.out.println("Method 1");
    }

    @Test(priority = 2)
    public void testMethodTwo(){
        System.out.println("Method 2");
    }

    @Test(priority = 3)
    public void testMethodThree(){
        System.out.println("Method 3");
    }
}
