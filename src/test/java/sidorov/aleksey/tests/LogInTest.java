package sidorov.aleksey.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class LogInTest {
    @Test
    public void login(){
        open("https://www.saucedemo.com/");
    }
}
