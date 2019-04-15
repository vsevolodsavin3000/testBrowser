package partnership.pageObjects.otherElements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class OtherCommonElements extends PageObject {

    @FindBy(css = ".support-trigger-round-icon.support-icon-comments-o")
    private WebElement buttonToWriteMessageToVlad;

    @FindBy(css = "iframe[id^='easyXDM_default']")
    private WebElement iframe;

    @FindBy(id = "chatTextarea")
    private WebElement textBox;

    @FindBy(xpath = "//a[contains(text(),'Отпр')]")
    private WebElement sendButton;

    @FindBy(css = ".text.first")
    private WebElement messageSent;

    @FindBy(className = "uk-icon-filter")
    private WebElement filterButton;

    @FindBy(xpath = "//div[@class='uk-modal-header']/h2")
    private WebElement filterHeader;

    @FindBy(css = ".uk-modal-close.uk-close")
    private WebElement closeButton;

    public OtherCommonElements(WebDriver driver) {
        super(driver);
    }

    public String writeMessageToVlad(){
        wait.until(ExpectedConditions.visibilityOf(this.buttonToWriteMessageToVlad)).click();
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(this.iframe));
        wait.until(ExpectedConditions.visibilityOf(this.textBox)).sendKeys("автотест, игнорируйте, хорошего дня");
        this.sendButton.click();
        return this.messageSent.getText();
    }

    public String pressFilterAndCheckTitle(){
        wait.until(ExpectedConditions.visibilityOf(this.filterButton)).click();
        return wait.until(ExpectedConditions.visibilityOf(this.filterHeader)).getText();
    }
    public void closeFilters() throws NoSuchElementException, StaleElementReferenceException, ElementNotVisibleException, WebDriverException {
        while(true) {
            try {
                this.closeButton.click();
            } catch (NoSuchElementException e) { break;
            } catch (StaleElementReferenceException e) {break;
            } catch (ElementNotVisibleException e) {break;
            } catch (WebDriverException e){break;}
        }
    }
}
