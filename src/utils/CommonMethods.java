package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class CommonMethods {


    //dynamic code to open and close a website on different browsers
    public static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser(){
        ConfigReader.readProperties("/Users/macbookprom1/eclipse-workspace/TestNG/src/com/syntax/config/config.properties");//copied from config reader

        switch (ConfigReader.getPropertyValue("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.out.println("browser unavailable");
                break;
        }
        driver.get(ConfigReader.getPropertyValue("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown(){
        driver.quit();

    }

}
