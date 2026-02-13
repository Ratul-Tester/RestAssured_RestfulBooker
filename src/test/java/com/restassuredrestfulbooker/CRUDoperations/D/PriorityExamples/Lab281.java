package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Test;

public class Lab281 {

    @Test(groups = {"Auth"}, priority = 1)
    public void getToken(){
        System.out.println("This is the Token");
    }

    @Test(groups = {"Auth"}, priority = 2)
    public void createBooking(){
        System.out.println("This is the Booking ID");
    }

    @Test(dependsOnGroups = {"Auth.*"}, priority = 0)
    public void updateBooking(){
        System.out.println("This is the Updated Booking");
    }
}
