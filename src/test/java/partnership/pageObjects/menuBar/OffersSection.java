package partnership.pageObjects.menuBar;

import partnership.pageObjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OffersSection extends PageObject {

    @FindBy(xpath = "//a[contains(text(),' Справочники')]")
    private WebElement spravochnikiButton;

    @FindBy(xpath = "//span[contains(text(),' Офферы')]")
    private WebElement offersButton;

    @FindBy(className = "uk-icon-filter")
    private WebElement filterButton;

    @FindBy(className = "vid_but")
    private WebElement videoButton;

    @FindBy(className = "uk-article-lead")
    private WebElement title;

    public OffersSection(WebDriver driver) {
        super(driver);
    }
    public void getToOffers(){
        wait.until(ExpectedConditions.visibilityOf(this.spravochnikiButton)).click();
        wait.until(ExpectedConditions.visibilityOf(this.offersButton)).click();
    }

    public String pressVideoAndGetTitle(){
        wait.until(ExpectedConditions.visibilityOf(this.videoButton)).click();
        return wait.until(ExpectedConditions.visibilityOf(this.title)).getText();
    }

    public OffersTabResultCheck pressFiltersButton(){
        wait.until(ExpectedConditions.elementToBeClickable(this.filterButton)).click();
        return new OffersTabResultCheck(driver);
    }
}
