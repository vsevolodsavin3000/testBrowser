package partnership.pageObjects.menuBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class BalanceSection extends PageObject {

    @FindBy(xpath = "//span[contains(text(),' Баланс')]")
    private WebElement balanceButton;

    @FindBy(xpath = "//h2[@id='set-name']/a")
    private WebElement balanceTitle;

    public BalanceSection(WebDriver driver) {
        super(driver);
    }

    public String clickBalanceAndGetTitle() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(this.balanceButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(this.balanceButton).doubleClick().perform();
        Thread.sleep(1500);
        return wait.until(ExpectedConditions.visibilityOf(this.balanceTitle)).getText();
    }
}
