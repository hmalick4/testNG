package com.syntax.class02;

import org.testng.annotations.Test;

public class DependsOnAttribute {

    @Test
    public void login(){
        System.out.println("this is my login method");
    }

    @Test(dependsOnMethods="login") //relying on login method
    public void verifyDashboardPage(){
        System.out.println("This is the dashboard page");
    }

    @Test(dependsOnMethods="verifyDashboardPage")
    public void verifyLogoutPage(){
        System.out.println("This is the logout page");
    }


}
