package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sidorov.aleksey.pages.InventoryPage;
import sidorov.aleksey.pages.LoginPage;

import static io.qameta.allure.Allure.step;


public class LogInTest extends TestBase{
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    @Test
    @Owner("Aleksey Sidorov")
    @Feature("Авторизация")
    @Story("Успешная авторизация")
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
            loginPage.userName.setValue(loginPage.getCredentials(loginPage.loginCredentials));
            loginPage.password.setValue(loginPage.getCredentials(loginPage.passwordCredentials));
            loginPage.loginButton.click();
        });

        step("Проверка отображения главной страницы приложения",()->{
            inventoryPage
                    .getPageHeader()
                    .checkTitle("Swag Labs");
        });
    }
}
