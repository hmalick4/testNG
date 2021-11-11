package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;
import utils.ConfigReader;

import java.util.concurrent.TimeUnit;

public class DataProviderDemo extends CommonMethods {

    WebDriver driver;

    //provides 2-d array to include all username and pwds
    @DataProvider
    public Object[][] loginData(){
        Object[][] data= new Object[3] [2]; //3 users (rows), 2 columns
        data[0][0]="Admin";
        data [0][1]="Hum@nhrm123";
        data [1][0]="Admin";
        data [1][1]="Hum@nhrm123";
        data [2][0]="Admin";
        data [2][1]="Hum@nhrm123";
        return data;
    }



    //test will execute 3 times bc have 3 pieces of login info
    @Test(dataProvider="loginData")
    public void validLogin(String username, String password) {
        driver.findElement(By.id("txtUsername")).sendKeys(ConfigReader.getPropertyValue("username"));
        driver.findElement(By.id("txtPassword")).sendKeys(ConfigReader.getPropertyValue("password"));
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

        @AfterMethod (alwaysRun = true)
                public void tearDown(){
                driver.quit();
        }

    }
