package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class AssertionAttribute {

    WebDriver driver;

    @BeforeClass
    public void beforeClassMethod(){
        System.out.println("I am before class method");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("I am after class method");
    }

    //beforemethod always executed immediately before Test
    @BeforeMethod
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        driver=new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority=1)
    public void ValidLogin(){
        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement pw=driver.findElement(By.id("txtPassword"));
        pw.sendKeys("Hum@nhrm123");
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement welcomeAttribute= driver.findElement(By.xpath("//*[@id='welcome']"));
        if(welcomeAttribute.isDisplayed()){
            System.out.println("Test case is valid and has passed.");
        }else{
            System.out.println("Test case is invalid and failed.");
        }
    }

    @Test (enabled = true, priority = 2)
    public void validationOfTitle(){
        String actualValue="Human Management System";
        String expectedText=driver.getTitle();
        Assert.assertEquals(actualValue, expectedText, "The values are not equal.");
        System.out.println("I am executing after assertion.");
    }


    @Test
    public void previousTest(){
        System.out.println("This is a test done by a different tester for a previous sprint.");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
