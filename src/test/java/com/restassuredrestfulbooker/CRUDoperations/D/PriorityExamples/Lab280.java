package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Test;

public class Lab280 {

    @Test(dependsOnMethods = {"getToken","getBookingId"})
    public void UpdateBooking(){
        System.out.println("Booking is Updated");
    }

    @Test(priority = 1)
    public void getToken(){
        System.out.println("This is the Token");
    }

    @Test(priority = 2)
    public void getBookingId(){
        System.out.println("This is the Booking ID");
    }

    @Test(dependsOnMethods = {"UpdateBooking"})
    public void CheckUpdateBooking(){
        System.out.println("I will run after booking is updated");
    }
}
