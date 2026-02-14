package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab283 {
    @Parameters("Browsers")
    @Test
    public void testDemoBrowser(String browser) {
        System.out.println("This is " + browser + " browser");

        switch (browser) {
            case "Chrome":
                System.out.println("Chrome browser is starting now");
                break;

            case "Firefox":
                System.out.println("Firefox browser is starting now");
                break;

            default:
                System.out.println("Nothing selected, so don't know what to start");

        }
    }
}
