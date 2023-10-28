package sidorov.aleksey.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement userName = $("#user-name");
    public SelenideElement password = $("#password");
    public SelenideElement loginButton = $("#login-button");
    public SelenideElement loginCredentials = $("#login_credentials");
    public SelenideElement passwordCredentials = $(".login_password");

    public String getCreds(SelenideElement element){
        return element.getText().split("\n")[1];
    }
}
