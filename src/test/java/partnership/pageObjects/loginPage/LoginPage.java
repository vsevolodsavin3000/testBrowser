package partnership.pageObjects.loginPage;

import partnership.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

    @FindBy(className = "enter")
    private WebElement loginButton0;

    @FindBy(id="user")
    private WebElement loginField;

    @FindBy(id="pass")
    private WebElement passwordField;

    @FindBy(xpath="//button[contains(text(),'Войти')]")
    private WebElement loginButton1;

    @FindBy(xpath = "//a[contains(text(),'Зарегистрироваться')]")
    private WebElement registrationButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterLoginPass(String loginField,String passwordField){
        this.loginField.clear();
        this.loginField.sendKeys(loginField);

        this.passwordField.clear();
        this.passwordField.sendKeys(passwordField);
    }

    public void firstPageLoginButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(this.loginButton0));
        Thread.sleep(500);
        this.loginButton0.click();
    }

    public void pressRegistrationButton() throws InterruptedException{
        wait.until(ExpectedConditions.visibilityOf(this.registrationButton));
        this.registrationButton.click();
    }

    public AfterLogin submit(){
        this.loginButton1.click();
        return new AfterLogin(driver);
    }
}
