package com.syntax.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW {
    /*
    open chrome browser
    nagivate to HRMS
    login into the application
    add 5 different employees and create login credentials by proving full name, username, pw
    verify employee has been successfully added, and take a screenshot of each time employee is added
    close the browser
    specify group for this test case
     */

    //data provider concept of adding multiple employees
    WebDriver driver;

    @DataProvider
    public Object[][] addEmp(){
        Object[][] data= new Object[5] [5]; //5 users (rows), 5 columns (first name, last name, username, pw, confirm pw
        data[0][0]="Bugs";
        data [0][1]="Bunny";
        data [0][2]="bB";
        data[0][3]="BugsBunny";
        data[0][4]="BugsBunny";

        data [1][0]="Spongebob";
        data [1][1]="Squarepants";
        data [1][2]="sS";
        data [1][3]="spongeBob";
        data [1][4]="spongeBob";

        data [2][0]="Uconn";
        data [2][1]="Husky";
        data [2][2]="uC";
        data [2][3]="uconnHusky";
        data [2][4]="uconnHusky";

        data [3][0]="Tom";
        data[3][1]="Jerry";
        data [3][2]="tJ";
        data[3][3]="tomJerry";
        data[3][4]="tomJerry";

        data [4][0]="Betty";
        data[4][1]="Boop";
        data[4][2]="bB";
        data[4][3]="bettyBoop";
        data [4][4]="bettyBoop";
        return data;
    }

    @BeforeMethod(alwaysRun=true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test(alwaysRun=true, groups="smoke")
    public void addEmployeeMethod(String firstName, String lastName, String username, String password, String confirmPassword) {
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        WebElement pw = driver.findElement(By.id("txtPassword"));
        userName.sendKeys("Hum@nhrm123");
        WebElement loginButton = driver.findElement(By.id("btnLogin"));
        loginButton.click();
        driver.findElement(By.id("menu_pim_viewPimModule")).click();
        driver.findElement(By.id("menu_pim_addEmployee")).click();
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("chkLogin")).click();
        driver.findElement(By.id("user_name")).sendKeys(username);
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.id("re_password")).sendKeys(confirmPassword);
        driver.findElement(By.id("btnSave")).click();

        WebElement createdName = driver.findElement(By.xpath("//div[@id ='profile-pic']/h1"));
        String createdNameText = createdName.getText();
        Assert.assertEquals(createdNameText, firstName + " " + lastName, "Employee was not created");
    }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
            driver.quit();
        }

        }
