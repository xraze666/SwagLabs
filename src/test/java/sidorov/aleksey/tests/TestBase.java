package sidorov.aleksey.tests;

import org.junit.jupiter.api.BeforeAll;
import sidorov.aleksey.helpers.DriverSetting;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        DriverSetting.configureDriver();
    }
}
