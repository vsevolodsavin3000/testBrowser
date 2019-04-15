package partnership.pageObjects.menuBar;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class PersonalAccountSection extends PageObject {

    @FindBy(xpath = "//span[contains(text(),' Личный кабинет')]")
    private WebElement personalAccountButton;

    @FindBy(xpath = "//h2[@id='set-name']/a[contains(text(),'Личный кабинет')]")
    private WebElement title;

    @FindBy(className = "uk-icon-filter")
    private WebElement filterButton;

    @FindBy(xpath = "//h2[contains(text(),'Фильтр')]")
    private WebElement filterTitle;

    @FindBy(css = ".uk-modal-close.uk-close")
    private WebElement closeButton;

    @FindBy(className = "uk-icon-area-chart")
    private WebElement graphButton;

    @FindBy(xpath = "//h2[@id='set-name']/a[contains(text(),'График')]")
    private WebElement graphTitle;

    public PersonalAccountSection(WebDriver driver) {
        super(driver);
    }

    public String pressPersonalAccountButtonAndGetTitle(){
        wait.until(ExpectedConditions.visibilityOf(this.personalAccountButton)).click();
        return wait.until(ExpectedConditions.visibilityOf(this.title)).getText();
    }

    public String pressFiltersAndGetTitle()throws NoSuchElementException, ElementNotVisibleException, WebDriverException {
        this.filterButton.click();
        String localTitle = wait.until(ExpectedConditions.visibilityOf(this.filterTitle)).getText();
        while (true) {
            try {
                this.closeButton.click();
            } catch (NoSuchElementException e) {
                break;
            }
            catch (ElementNotVisibleException e) {
                break;
            }
            catch (WebDriverException e){
                break;
            }
        }
        return localTitle;
    }

    public String pressGraphAndGetTitle(){
        this.graphButton.click();
/*        windows.clear();
        windows.addAll(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));*/
        String miscGraphTitle = wait.until(ExpectedConditions.visibilityOf(this.graphTitle)).getText();
        return miscGraphTitle;
    }
}
