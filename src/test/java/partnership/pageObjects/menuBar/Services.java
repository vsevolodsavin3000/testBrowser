package partnership.pageObjects.menuBar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class Services extends PageObject {

    @FindBy(xpath = "//span[contains(text(),' Сервисы')]")
    private WebElement servicesButton;

    @FindBy(xpath = "//span[contains(text(),' Delete test user')]")
    private WebElement deleteTestUserButton;

    @FindBy(xpath = "//span[contains(text(),'Удалить')]")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    private WebElement okButton;

    @FindBy(xpath = "//div[contains(text(),'Пользователь \"test_testovish@mail.ru\"')]")
    private WebElement successDeleteMessage;

    public Services(WebDriver driver) {
        super(driver);
    }

    public String deleteTestUserAndGetSuccessMessage(){
        wait.until(ExpectedConditions.visibilityOf(this.servicesButton)).click();
        wait.until(ExpectedConditions.visibilityOf(this.deleteTestUserButton)).click();
        wait.until(ExpectedConditions.visibilityOf(this.deleteButton)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(),'Удалить пользователя \"test_testovish@mail.ru\"?')]")));
        wait.until(ExpectedConditions.visibilityOf(this.okButton)).click();
        return wait.until(ExpectedConditions.visibilityOf(this.successDeleteMessage)).getText();
    }
}
