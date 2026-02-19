package com.restassuredrestfulbooker.Listners;

import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;

public class CustomListner289 implements IExecutionListener, ISuiteListener {
    @Override
    public void onExecutionStart() {
        IExecutionListener.super.onExecutionStart();
        System.out.println("onExecutionStart of Method IExecutionListener");
        long startTime= System.currentTimeMillis();
        System.out.println(" ****   *** Method Started execution at - "+ startTime + "****   *** ");
    }

    @Override
    public void onExecutionFinish() {
        IExecutionListener.super.onExecutionFinish();
        long endTime= System.currentTimeMillis();
        System.out.println("****   *** Method Finished execution at- "+ endTime +"****   *** ");
        System.out.println("onExecutionFinish of Method IExecutionListener");
    }

    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        System.out.println("onExecutionStart of Suite");
        long startTime= System.currentTimeMillis();
        System.out.println(" ****   *** Suite Started execution at - "+ startTime + "****   *** ");
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        long endTime= System.currentTimeMillis();
        System.out.println("****   *** Suite Finished execution at- "+ endTime +"****   *** ");
        System.out.println("onExecutionFinish of Suite");
    }
}
