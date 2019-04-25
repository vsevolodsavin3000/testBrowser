package partnership.tests;

import org.opentest4j.AssertionFailedError;
import partnership.pageObjects.loginPage.LoginPage;
import partnership.pageObjects.loginPage.AfterLogin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BrowserStackJUnitTest {

    @Test
    @DisplayName("Login")
    public void signUp() throws InterruptedException, IOException {
        driver.get("https://partners.mks.group");

        LoginPage loginPage = new LoginPage(driver);
        //loginPage.firstPageLoginButton();
        String password = Files.readAllLines(Paths.get("C:/1/1/browserTestsPasswords.config")).get(1);
        loginPage.enterLoginPass("vsevolodsavin3000@gmail.com",password);

        AfterLogin afterlogin = loginPage.submit();
        assertEquals("vsevolodsavin3000@gmail.com",afterlogin.confirmationLoginData());
    }
//s.kastanov@adviator.com kKGUpb9T
    @Test
    @DisplayName("Logout")
    public void signOut(){
        AfterLogin afterLogin = new AfterLogin(driver);
        afterLogin.logout();
        driver.navigate().refresh();
        try {
            assertEquals("https://partners.mks.group/www/index", driver.getCurrentUrl());
        }
        catch (AssertionFailedError e){
            assertEquals("https://partners.mks.group/www/index?", driver.getCurrentUrl());
        }
    }
}
