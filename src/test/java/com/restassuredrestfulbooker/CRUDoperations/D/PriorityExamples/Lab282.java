package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Lab282 {

    @Parameters("browser")
    @Test
    public void testBrowser(String value) {
        System.out.println("This is " + value + " Browser");

        switch (value) {
            case "firefox":
                // Firefox Code
                System.out.println("Firefox starting and Running TC");
                break;
            case "chrome":
                // Chrome Code
                System.out.println("Chrome starting and Running TC");
                break;
            default:
                System.out.println("NO idea WHAT TO START");
        }
    }
}
