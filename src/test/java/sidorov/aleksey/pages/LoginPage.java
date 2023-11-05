package sidorov.aleksey.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {
    public SelenideElement loginPageTitle = $(".login_logo");
    public SelenideElement userName = $("#user-name");
    public SelenideElement password = $("#password");
    public SelenideElement loginButton = $("#login-button");
    public SelenideElement loginCredentials = $("#login_credentials");
    public SelenideElement passwordCredentials = $(".login_password");
    public SelenideElement errorLoginContainer = $(".error-message-container");
    public SelenideElement errorMessage = errorLoginContainer.find("[data-test='error']");
    public SelenideElement refreshErrorButton = errorLoginContainer.find(".error-button");

    public String getCreds(SelenideElement element){
        return element.getText().split("\n")[1];
    }
    public LoginPage openLoginPage(){
        open("");
        return this;
    }
}
