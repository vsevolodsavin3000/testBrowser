package partnership.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import partnership.pageObjects.loginPage.LoginPage;
import partnership.pageObjects.loginPage.MailPage;
import partnership.pageObjects.loginPage.RegistrationPage;
import partnership.pageObjects.menuBar.Services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends BrowserStackJUnitTest {

    @Test
    @DisplayName("Registration check")
    public void registrationTest() throws InterruptedException, IOException {
        driver.get("https://partners.mks.group/www/index");
        String password = Files.readAllLines(Paths.get("C:/1/1/browserTestsPasswords.config")).get(1);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.pressRegistrationButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.pressRegistrationButton();
        assertEquals("Не заполнено поле Email",registrationPage.getAlertMessage());

        registrationPage.enterStringToEmailField("abrakadabra");
        registrationPage.pressRegistrationButton();
        assertEquals("Укажите корректный e-mail",registrationPage.getAlertMessage());

        registrationPage.enterStringToEmailField("test_testovish@mail.ru");
        registrationPage.pressRegistrationButton();
        assertEquals("Не заполнено поле Пароль",registrationPage.getAlertMessage());

        registrationPage.enterStringToPasswordField("!");
        registrationPage.pressRegistrationButton();
        assertEquals("Не заполнено поле Телефон",registrationPage.getAlertMessage());
//ТУТ надо потом будет написать тест на то что проверяется количество символов в номере телефона
        registrationPage.enterStringToPhoneField("81231234565");
        registrationPage.pressRegistrationButton();
        assertEquals("Пароль должен быть не менее 8 символов, допустимые символы: [A-Za-z0-9%*()?@#$~]",registrationPage.getAlertMessage());

        registrationPage.enterStringToPasswordField(password);
        registrationPage.pressRegistrationButton();
        assertEquals("Подтверждение пароля не соответвует паролю",registrationPage.getAlertMessage());

        registrationPage.enterStringToPasswordConfirmationField(password);
        registrationPage.pressRegistrationButton();
        assertEquals("Для продолжения необходимо подтвердить согласие с Договором оферты",registrationPage.getAlertMessage());

        registrationPage.enterStringToSurnameField("Тестов");
        registrationPage.enterStringToNameField("Тестер");
        registrationPage.enterStringToPatronymicField("Тестерович");
        registrationPage.pressCheckbox();
        registrationPage.pressRegistrationButton();

        Thread.sleep(5000); //письмо не успевает мгновенно прийти

        driver.get("https://mail.ru/");
        MailPage mailPage = new MailPage(driver);
        mailPage.pressLinkInsideMessage();
        assertEquals("Для начала работы в партнёрской программе необходимо произвести активацию вашего аккаунта.\n" +
                "Для этого, вам необходимо связаться с вашим личным менеджером по этим контактам:\n" +
                "Skype: i_roman_ko\n" +
                "Telegram: @RomanMKS\n" +
                "Почта: r.kovtun@elari.net",registrationPage.getAlertMessage());

        loginPage.enterLoginPass("s.kastanov@adviator.com","kKGUpb9T");
        loginPage.submit();
        Services services = new Services(driver);
        assertEquals("Пользователь \"test_testovish@mail.ru\" удален успешно.",services.deleteTestUserAndGetSuccessMessage());
}
}
