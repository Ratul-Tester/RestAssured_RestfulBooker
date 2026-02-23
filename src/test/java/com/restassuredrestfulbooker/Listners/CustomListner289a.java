package com.restassuredrestfulbooker.Listners;

import org.testng.*;

public class CustomListner289a implements ISuiteListener, ITestListener, IClassListener, IInvokedMethodListener, IExecutionListener {

    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
        System.out.println("onExecutionStart");
        long startTime= System.currentTimeMillis();
        System.out.println(" ****   *** Started execution at - "+ startTime + "****   *** ");

    }

    @Override
    public void onExecutionFinish() {
        IExecutionListener.super.onExecutionFinish();
        System.out.println("onExecutionFinish");
        long endTime= System.currentTimeMillis();
        System.out.println(" ****   *** Finished execution at - "+ endTime + "****   *** ");

    }

    @Override
    public void onBeforeClass(ITestClass testClass) {
        IClassListener.super.onBeforeClass(testClass);
    }

    @Override
    public void onAfterClass(ITestClass testClass) {
        IClassListener.super.onAfterClass(testClass);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.beforeInvocation(method, testResult, context);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        IInvokedMethodListener.super.afterInvocation(method, testResult, context);
    }

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        System.out.println("onSuiteStart");
        long suiteStartTime= System.currentTimeMillis();
        System.out.println(" ****   *** Started Suite at - "+ suiteStartTime + "****   *** ");
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        System.out.println("onSuiteFinish");
        long suiteFinishTime= System.currentTimeMillis();
        System.out.println(" ****   *** Finished Suite at - "+ suiteFinishTime + "****   *** ");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public boolean isEnabled() {
        return ISuiteListener.super.isEnabled();
    }
}
