package partnership.tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.TimeoutException;
import partnership.pageObjects.menuBar.*;
import partnership.pageObjects.otherElements.OtherCommonElements;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MenuButtonsTests extends BrowserStackJUnitTest {

    @BeforeAll
    public static void forStarters() throws InterruptedException, IOException {
        LoginTest loginTest = new LoginTest();
        loginTest.signUp();
    }

    @Test
    @DisplayName("Create ticket button leads to helpdesk")
    public void createTicket() throws TimeoutException {
        CreateTicket createTicket = new CreateTicket(driver);
        HelpdeskWindow helpdeskWindow = createTicket.pressCreateTicket();
        try {
            assertEquals("https://techliniya.freshdesk.com/support/tickets/new", helpdeskWindow.confirmNewTabWithHelpdeskOpened());
        } catch (TimeoutException e){fail("Страница с хелпдеском грузится непозволительно долго(больше 30 секунд)");}
    }

    @Test
    @DisplayName("Offers section")
    public void offersTabFuncs()  {
        OffersSection offersTab = new OffersSection(driver);
        offersTab.getToOffers();

        OffersTabResultCheck offersTabResultCheck = offersTab.pressFiltersButton();
        assertEquals("Фильтр", offersTabResultCheck.confirmationOffersName());
        offersTabResultCheck.closeFilters();

        assertEquals("Раздел \"Офферы\", получение ссылки и добавление параметров",offersTab.pressVideoAndGetTitle());
    }

    @Test
    @DisplayName("Personal account section")
    public void personalAccount(){
        PersonalAccountSection personalAccountSection = new PersonalAccountSection(driver);
        assertEquals("Личный кабинет",personalAccountSection.pressPersonalAccountButtonAndGetTitle());
        assertEquals("Фильтр",personalAccountSection.pressFiltersAndGetTitle());
        assertEquals("График",personalAccountSection.pressGraphAndGetTitle());
    }

    @Test
    @DisplayName("Campaign section")
    public void campaignTest(){
        CampaignSection campaignSection = new CampaignSection(driver);
        OtherCommonElements otherCommonElements = new OtherCommonElements(driver);
        assertEquals("Кампании",campaignSection.pressCampaignAndGetTitle());
        assertEquals("Фильтр",otherCommonElements.pressFilterAndCheckTitle());
        otherCommonElements.closeFilters();
    }

    @Test
    @DisplayName("Balance section")
    public void balanceSectionTest() throws InterruptedException {
        BalanceSection balanceSection = new BalanceSection(driver);
        OtherCommonElements otherCommonElements = new OtherCommonElements(driver);
        assertEquals("Баланс",balanceSection.clickBalanceAndGetTitle());
        assertEquals("Фильтр",otherCommonElements.pressFilterAndCheckTitle());
        otherCommonElements.closeFilters();
    }

/*    @Test
    @DisplayName("Write message to Vlad")
    public void writeMessageToVlad(){
        OtherCommonElements otherCommonElements = new OtherCommonElements(driver);
        assertEquals("автотест, игнорируйте, хорошего дня",otherCommonElements.writeMessageToVlad());
    }*/

    @AfterEach
    public void cleanUpAll(){
    ArrayList<String> windows = new ArrayList();
    windows.addAll(driver.getWindowHandles());
    for(int i = 1;i<windows.size();i++){
        driver.switchTo().window(windows.get(i)).close();
    }
    driver.switchTo().window(windows.get(0));
    windows.clear();
    }
}
