package partnership.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//для запуска без браузерстака

public class FunctionalTest   {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        System.setProperty("webdriver.chrome.driver","C:/chromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    }

    @AfterEach
    public void cleanUp(){
        driver.switchTo().defaultContent();
    }

    @AfterAll
    public static void tearDownDriver(){
        //driver.manage().deleteAllCookies();
        for(String window : driver.getWindowHandles() ){
            driver.switchTo().window(window).close();
        }
        driver.quit();
    }
}