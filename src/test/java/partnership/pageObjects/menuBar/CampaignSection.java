package partnership.pageObjects.menuBar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import partnership.pageObjects.PageObject;

public class CampaignSection extends PageObject {

    @FindBy(xpath = "//a[contains(text(),' Кампании')]")
    private WebElement campaignButton;

    @FindBy(xpath = "//h2[@id='set-name']/a")
    private WebElement title;

    @FindBy(id = "createButton")
    private WebElement createButton;

    public CampaignSection(WebDriver driver) {
        super(driver);
    }

    public String pressCampaignAndGetTitle(){
        wait.until(ExpectedConditions.visibilityOf(this.campaignButton)).click();
        wait.until(ExpectedConditions.visibilityOf(this.createButton));
        return wait.until(ExpectedConditions.visibilityOf(this.title)).getText();
    }
}
