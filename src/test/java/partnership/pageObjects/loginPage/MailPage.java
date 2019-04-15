package partnership.pageObjects.loginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MailPage extends PageObject {

    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'info@partners.mks.group')]")
    private WebElement subjectOfANewMail;

    @FindBy(partialLinkText = "https://partners.mks.group")
    private WebElement linkItself;

    private String filePath ="C:/1/1/browserTestsPasswords.config";

    public MailPage(WebDriver driver) {
        super(driver);
    }

    public void pressLinkInsideMessage() throws IOException {
        String password = Files.readAllLines(Paths.get("C:/1/1/browserTestsPasswords.config")).get(0);
        wait.until(ExpectedConditions.visibilityOf(this.loginField)).sendKeys("test_testovish@mail.ru");
        this.passwordField.sendKeys(password);
        this.loginButton.click();
        wait.until(ExpectedConditions.visibilityOf(this.subjectOfANewMail)).click();
        wait.until(ExpectedConditions.visibilityOf(this.linkItself)).click();

        windows.clear();
        windows.addAll(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

    }
}
