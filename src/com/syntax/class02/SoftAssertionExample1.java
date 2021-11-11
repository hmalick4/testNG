package com.syntax.class02;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample1 {

    @Test
    public void softAssertionValidation(){
        String expected=("Batch 10 is the best batch.");
        String actual=("Batch 10 is the worst batch.");

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(expected, actual);
        System.out.println("The code afer first assertion");

        softAssert.assertTrue(false);
        System.out.println("The code after second assertion");

        softAssert.assertFalse(true);
        System.out.println("The code after third assertion");

        softAssert.assertFalse(false);
        System.out.println("My code after fourth assertion");

        String newExpected="This is the last assertion.";
        String newActual="This is the last assertion.";
        softAssert.assertEquals(newExpected, newActual);

        //always last statement in soft assert to get report
        softAssert.assertAll();

    }

    @Test
    public void anotherMethod(){
        System.out.println("Another method");
    }

}
