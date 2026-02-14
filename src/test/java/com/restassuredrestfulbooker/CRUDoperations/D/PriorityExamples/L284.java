package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class L284 {

    @Parameters("Browsers")
    @Test
    public void testBrowserDemo(String browser){
        System.out.println("This is "+browser+" browser");

        switch (browser){
            case "Chrome":
                System.out.println("Chrome is starting");
                break;

            case "Firefox":
                System.out.println("Firefox is starting");
                break;

            default:
                System.out.println("Please check what you have entered couldn't find the browser");

        }
    }

}
