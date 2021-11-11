package com.syntax.class01;

import org.testng.annotations.*;

public class HW {

    /*
    Executing different test based TestNG annotations
    -create a class that will have:
    before and after class annotation,
    before and after method annotation,
    two methods with Test annotation.
    Observe the results
     */

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }

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

    @Test
    public void bTest(){
        System.out.println("B test");
    }

    @Test
    public void aTest(){
        System.out.println("A test");
    }

}
