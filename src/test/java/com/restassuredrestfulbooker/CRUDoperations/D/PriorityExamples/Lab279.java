package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Lab279 {

    @Test(groups = {"Sanity"}, priority = 0)
    public void SanityPart1Run(){
        System.out.println("Sanity Part 1 TC");
    }

    @Test(groups = {"Sanity","Smoke"})
    public void SanityPart2Run(){
        System.out.println("Sanity Part 2 TC");
    }

    @Test(groups = {"Regression"})
    public void RegressionRun(){
        System.out.println("Regression TC");
    }

    @Test(groups = {"Smoke"})
    public void SmokeRun(){
        System.out.println("Smoke TC");
        Assert.assertTrue(true);
    }

    @Test(groups = {"QA","Production"})
    public void QARun(){
        System.out.println("QA TC");
    }

    @Test(groups = {"Production"})
    public void ProductionRun(){
        System.out.println("Production TC");
    }
}
