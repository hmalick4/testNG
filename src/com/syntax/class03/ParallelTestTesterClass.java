package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelTestTesterClass {

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

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    //test will execute 3 times bc have 3 pieces of login info
    @Test(dataProvider="loginData")
    public void validLogin(String username, String password) {
        driver.findElement(By.id("txtUsername")).sendKeys("username");
        driver.findElement(By.id("txtPassword")).sendKeys("password");
        driver.findElement(By.id("btnLogin")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

}
