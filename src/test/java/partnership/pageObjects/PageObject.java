package partnership.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait ;
    protected ArrayList<String> windows;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,20,500);
        windows= new ArrayList<String>();
        PageFactory.initElements(driver, this);
    }
}