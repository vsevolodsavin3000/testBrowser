package partnership.pageObjects.loginPage;

import partnership.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AfterLogin extends PageObject {

    @FindBy(id = "loginData")
    private WebElement loginData;

    public AfterLogin(WebDriver driver) {
        super(driver);
    }

    public String confirmationLoginData(){
        wait.until(ExpectedConditions.visibilityOf(loginData));
        return loginData.getText();
    }

    public void logout(){
        wait.until(ExpectedConditions.visibilityOf(this.loginData)).click();
    }
}
