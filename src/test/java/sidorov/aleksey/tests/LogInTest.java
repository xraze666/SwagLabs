package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import sidorov.aleksey.pages.LoginPage;
import sidorov.aleksey.pages.MainPage;


public class LogInTest extends TestBase{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    @Test
    public void login()
    {
        loginPage
                .openLoginPage()
                .loginPageTitle.should(Condition.visible);
        loginPage.userName.setValue(loginPage.getCreds(loginPage.loginCredentials));
        loginPage.password.setValue(loginPage.getCreds(loginPage.passwordCredentials));
        loginPage.loginButton.click();

        mainPage
                .getPageHeader()
                .checkTitle("Swag Labs");
    }
}
