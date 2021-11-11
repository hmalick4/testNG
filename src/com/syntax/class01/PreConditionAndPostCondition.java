package com.syntax.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PreConditionAndPostCondition {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am before method and will exectue before every test.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("I am after method and will execute after every test. ");
    }

    @Test
    public void firstMethod(){
        System.out.println("This is the first method.");
    }

    @Test
    public void secondMethod(){
        System.out.println("This is the second method.");
    }

}
