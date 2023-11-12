package sidorov.aleksey.pageElements;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PageHeader {
    public SelenideElement headerContainer = $("#header_container");
    public SelenideElement title = headerContainer.find(".app_logo");
    public SelenideElement shoppingCartContainer = headerContainer.find("#shopping_cart_container");
    public SelenideElement shoppingCartBadge = shoppingCartContainer.find(".shopping_cart_badge");
    public SelenideElement burgerMenuButton = headerContainer.find(".bm-burger-button");

    @Step("На странице отображается заголовок {title}")
    public void checkTitle(String title){
        this.title.shouldHave(text(title));
    }
    public void checkBadgeCount(String count){
        shoppingCartBadge.shouldHave(text(count));
    }
}
