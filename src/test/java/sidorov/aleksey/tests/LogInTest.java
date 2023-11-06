package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sidorov.aleksey.pages.LoginPage;
import sidorov.aleksey.pages.MainPage;

import static io.qameta.allure.Allure.step;


public class LogInTest extends TestBase{
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    @Test
    @DisplayName("Login with correct login/password")
    @Severity(SeverityLevel.CRITICAL)
    public void login()
    {
        step("Открываем страницу авторизации", ()->{
            loginPage
                    .openLoginPage()
                    .loginPageTitle.should(Condition.visible);
        });

        step("Ввод учетных данных указанных на странице",()->{
            loginPage.userName.setValue(loginPage.getCreds(loginPage.loginCredentials));
            loginPage.password.setValue(loginPage.getCreds(loginPage.passwordCredentials));
            loginPage.loginButton.click();
        });

        step("Проверка отображения главной страницы приложения",()->{
            mainPage
                    .getPageHeader()
                    .checkTitle("Swag Labs");
        });
    }
}
