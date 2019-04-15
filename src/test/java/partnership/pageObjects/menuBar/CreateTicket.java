package partnership.pageObjects.menuBar;

import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateTicket extends PageObject {

    @FindBy(className = "sup_but")
    private WebElement createTicket;

    public CreateTicket(WebDriver driver) {
        super(driver);
    }

    public HelpdeskWindow pressCreateTicket(){
        wait.until(ExpectedConditions.visibilityOf(this.createTicket)).click();
        windows.addAll(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));
        return new HelpdeskWindow(driver);
    }
}
