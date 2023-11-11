package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
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
    @Owner("Aleksey Sidorov")
    @DisplayName("Авторизация под корректной учетной записью")
    @Severity(SeverityLevel.CRITICAL)
    public void login()
    {
        step("Открытие страницы авторизации", ()->{
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
