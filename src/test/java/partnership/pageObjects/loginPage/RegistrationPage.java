package partnership.pageObjects.loginPage;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class RegistrationPage extends PageObject {

    @FindBy(id = "new_user")
    private WebElement emailField;

    @FindBy(id = "new_pass")
    private WebElement passwordField;

    @FindBy(id = "new_confirm_pass")
    private WebElement confirmPasswordField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "surname")
    private WebElement surnameField;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "patronymic")
    private WebElement patronymicField;

    @FindBy(id = "offer_check")
    private WebElement acceptCheckbox;

    @FindBy(xpath = "//button[contains(text(),'Зарегистрироваться')]")
    private WebElement registerButton;

    @FindBy(className = "uk-text-danger")
    private WebElement alertMessage;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement okButoon;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public String getAlertMessage()throws StaleElementReferenceException,NoSuchElementException{
        String localStringFromAlertMessage = wait.until(ExpectedConditions.visibilityOf(this.alertMessage)).getText();
        try {
            Actions actions = new Actions(driver);
            while (isElementPresent(By.xpath("//button[contains(text(),'Ok')]"))) {
                actions.moveToElement(this.okButoon).click().perform();
            }
            return localStringFromAlertMessage;
        }
        catch(StaleElementReferenceException e){
            return localStringFromAlertMessage;
        }
        catch(NoSuchElementException e){
            return localStringFromAlertMessage;
        }
    }

    public void pressRegistrationButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(this.registerButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(this.registerButton).click().perform();
    }

    public void enterStringToEmailField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.emailField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.emailField)).sendKeys(stringText);
    }

    public void enterStringToPasswordField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.passwordField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.passwordField)).sendKeys(stringText);
    }

    public void enterStringToPasswordConfirmationField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.confirmPasswordField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.confirmPasswordField)).sendKeys(stringText);
    }

    public void enterStringToPhoneField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.phoneField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.phoneField)).sendKeys(stringText);
    }

    public void enterStringToSurnameField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.surnameField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.surnameField)).sendKeys(stringText);
    }

    public void enterStringToNameField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.nameField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.nameField)).sendKeys(stringText);
    }

    public void enterStringToPatronymicField(String stringText){
        wait.until(ExpectedConditions.visibilityOf(this.patronymicField)).clear();
        wait.until(ExpectedConditions.visibilityOf(this.patronymicField)).sendKeys(stringText);
    }

    public void pressCheckbox() throws InterruptedException{
        Actions actions = new Actions(driver);
        actions.moveToElement(this.acceptCheckbox).click().perform();
    }

    public boolean isElementPresent(By locatorKey) {
        try {
            driver.findElement(locatorKey);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
        catch (StaleElementReferenceException e){
            return false;
        }
    }
}
