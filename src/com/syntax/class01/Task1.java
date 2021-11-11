package com.syntax.class01;

import org.testng.annotations.Test;

public class Task1 {

    //task1: executing tests using @Test
    //create three tests with unique @test methods names. execute all test methods.

        @Test
    public void method1(){
            System.out.println("Method 1");
        }

    @Test
    public void secondMethod(){
        System.out.println("Method 2");
    }

    @Test
    public void newestMethod(){
        System.out.println("Method 3");
    }
}
