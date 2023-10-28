package sidorov.aleksey.helpers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import sidorov.aleksey.config.Config;

public class DriverSetting {
    private static final Config config = ConfigFactory.create(Config.class);

    public static void configureDriver() {
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.baseUrl = config.baseUrl();
    }
}
