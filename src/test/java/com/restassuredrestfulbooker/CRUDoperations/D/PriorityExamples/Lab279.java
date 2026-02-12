package com.restassuredrestfulbooker.CRUDoperations.D.PriorityExamples;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Lab279 {

    @Issue("#JIRA-119")
    @AllureId("#TC 1a")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sanity TC")
    @Test(groups = {"Sanity"}, priority = 0)
    public void SanityPart1Run(){
        System.out.println("Sanity Part 1 TC");
    }

    @Issue("#JIRA-120")
    @AllureId("#TC 1b")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sanity TC")
    @Test(groups = {"Sanity","Smoke"}, priority = 1)
    public void SanityPart2Run(){
        System.out.println("Sanity Part 2 TC");
    }

    @Issue("#JIRA-121")
    @AllureId("#TC 2")
    @Severity(SeverityLevel.NORMAL)
    @Description("Regression TC")
    @Test(groups = {"Regression"}, priority = 2)
    public void RegressionRun(){
        System.out.println("Regression TC");
    }

    @Issue("#JIRA-122")
    @AllureId("#TC 3")
    @Severity(SeverityLevel.NORMAL)
    @Description("Smoke TC")
    @Test(groups = {"Smoke"}, priority = 3)
    public void SmokeRun(){
        System.out.println("Smoke TC");
        Assert.assertTrue(true);
    }

    @Issue("#JIRA-123")
    @AllureId("#TC 4")
    @Severity(SeverityLevel.NORMAL)
    @Description("QA TC")
    @Test(groups = {"QA","Production"}, priority = 4)
    public void QARun(){
        System.out.println("QA TC");
    }

    @Issue("#JIRA-124")
    @AllureId("#TC 5")
    @Severity(SeverityLevel.NORMAL)
    @Description("Production TC")
    @Test(groups = {"Production"}, priority = 5)
    public void ProductionRun(){
        System.out.println("Production TC");
    }
}
