package partnership.pageObjects.menuBar;

import partnership.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HelpdeskWindow extends PageObject {

    @FindBy(id = "helpdesk_ticket_email")
    private WebElement checkContainerLoaded;

    public HelpdeskWindow(WebDriver driver) {
        super(driver);
    }

    public String confirmNewTabWithHelpdeskOpened(){
        wait.until(ExpectedConditions.visibilityOf(checkContainerLoaded));
        windows.clear();
        return driver.getCurrentUrl();
    }
}
