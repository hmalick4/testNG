package com.syntax.class01;

import org.testng.annotations.Test;

public class PriorityAttribute {

    @Test (priority = 2)
    public void loginMethod(){
        System.out.println("I am login method");
    }

    @Test(priority =1)
    public void launchBrowserMethod(){
        System.out.println("I am launch browser method");
    }

    @Test(priority=3)
    public void closeBrowserMethod(){
        System.out.println("I am close browser method");
    }





}
