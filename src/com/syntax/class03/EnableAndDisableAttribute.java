package com.syntax.class03;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class EnableAndDisableAttribute {

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){ System.out.println("Before Class"); }

    @AfterClass
    public void afterClass(){
        System.out.println("After class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }

    //false and true for enable
    @Test (enabled=false, priority=2)
    public void bTest(){
        System.out.println("B test");
    }

    @Test (enabled=true, priority=1)
    public void aTest(){
        System.out.println("A test");
    }

}
