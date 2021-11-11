package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SoftAssertionExample2 {

    WebDriver driver;

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

        String titleExpected="Human Resource Management System";
        String titleActual=driver.getTitle();

        SoftAssert soft=new SoftAssert();
        soft.assertEquals(titleActual, titleExpected);

        WebElement userName= driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement pw=driver.findElement(By.id("txtPassword"));
        pw.sendKeys("Hum@nhrm123");
        WebElement loginButton=driver.findElement(By.id("btnLogin"));
        loginButton.click();

        WebElement welcomeAttribute= driver.findElement(By.xpath("//*[@id='welcome']"));
        String text=welcomeAttribute.getText();
        soft.assertFalse(welcomeAttribute.isDisplayed()); //expecting false. if true, assertion fails
        String expectedText="Welcome Admin123";
        soft.assertEquals(text,expectedText); //testing if text equals expected text
        System.out.println("My statement after all of the soft assertions");
        soft.assertAll();

        }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
