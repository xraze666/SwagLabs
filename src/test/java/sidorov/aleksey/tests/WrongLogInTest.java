package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import sidorov.aleksey.pages.LoginPage;
import sidorov.aleksey.pages.MainPage;

public class WrongLogInTest extends TestBase{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void wrongLogin(){
        loginPage
                .openLoginPage()
                .loginPageTitle.should(Condition.visible);
        loginPage.userName.setValue("Autotest WrongUser");
        loginPage.password.setValue("123456");
        loginPage.loginButton.click();

        loginPage.errorLoginContainer.should(Condition.visible);
        loginPage.userName.shouldHave(Condition.cssClass("input_error"));
        loginPage.password.shouldHave(Condition.cssClass("error"));

        loginPage.errorMessage.shouldHave(Condition.text("Epic sadface: Username and password do not match any user in this service"));

        mainPage.getPageHeader().title.shouldNot(Condition.visible);
    }
}
