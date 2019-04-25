package partnership;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import partnership.tests.BrowserStackJUnitTest;
import partnership.tests.LoginTest;
import partnership.tests.MenuButtonsTests;
import partnership.tests.RegistrationTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({RegistrationTest.class, LoginTest.class, MenuButtonsTests.class})
public class TestSuitePartners extends BrowserStackJUnitTest {
}
//mvn surefire:test -Dtest=src/test/java/partnership/TestSuitePartners.java
