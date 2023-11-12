package sidorov.aleksey.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sidorov.aleksey.pages.LoginPage;


import static io.qameta.allure.Allure.step;

public class WrongLogInTest extends TestBase{
    LoginPage loginPage = new LoginPage();

    @Test
    @Owner("Aleksey Sidorov")
    @Feature("Авторизация")
    @Story("Некорректные логин/пароль")
    @DisplayName("Авторизация под некорректной учетной записью")
    @Severity(SeverityLevel.CRITICAL)
    public void wrongCredentialsLogin(){
        step("Открытие страницы авторизации", ()->{
            loginPage
                    .openLoginPage()
                    .loginPageTitle.should(Condition.visible);
        });

        step("Ввод некорректных учетных данных",()->{
            loginPage.userName.setValue("Autotest WrongUser");
            loginPage.password.setValue("123456");
            loginPage.loginButton.click();
        });

        step("Отображение ошибки авторизации", ()->{
            loginPage.errorLoginContainer.should(Condition.visible);
            loginPage.userName.shouldHave(Condition.cssClass("input_error"));
            loginPage.password.shouldHave(Condition.cssClass("error"));
            loginPage.errorMessage.shouldHave(Condition.text("Epic sadface: Username and password do not match any user in this service"));
        });
    }

    @Test
    @Owner("Aleksey Sidorov")
    @Feature("Авторизация")
    @Story("Заблокированный аккаунт")
    @DisplayName("Авторизация под заблокированной учетной записью")
    @Severity(SeverityLevel.CRITICAL)
    public void lockedOutLogin(){
        step("Открытие страницы авторизации", ()->{
            loginPage
                    .openLoginPage()
                    .loginPageTitle.should(Condition.visible);
        });

        step("Ввод некорректных учетных данных",()->{
            loginPage.userName.setValue("locked_out_user");
            loginPage.password.setValue("secret_sauce");
            loginPage.loginButton.click();
        });

        step("Отображение ошибки заблокированного аккаунта", ()->{
            loginPage.errorLoginContainer.should(Condition.visible);
            loginPage.userName.shouldHave(Condition.cssClass("input_error"));
            loginPage.password.shouldHave(Condition.cssClass("error"));
            loginPage.errorMessage.shouldHave(Condition.text("Epic sadface: Sorry, this user has been locked out."));
        });
    }
}
