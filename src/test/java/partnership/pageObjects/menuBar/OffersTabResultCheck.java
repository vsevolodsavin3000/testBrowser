package partnership.pageObjects.menuBar;

import org.openqa.selenium.*;
import partnership.pageObjects.PageObject;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OffersTabResultCheck extends PageObject {

    @FindBy(xpath = "//div[@class='uk-modal-header']/h2")
    private WebElement filterHeader;

    @FindBy(css = ".uk-modal-close.uk-close")
    private WebElement closeButton;

    public OffersTabResultCheck(WebDriver driver) {
        super(driver);
    }

    public String confirmationOffersName(){
        wait.until(ExpectedConditions.visibilityOf(this.filterHeader));
        return filterHeader.getText();
    }

    public void closeFilters() throws NoSuchElementException , StaleElementReferenceException, ElementNotVisibleException {
        while(true) {
            try {
                this.closeButton.click();
            } catch (NoSuchElementException e) { break;
            } catch (StaleElementReferenceException e) {break;
            } catch (ElementNotVisibleException e) {break;
            }
        }
    }

}
