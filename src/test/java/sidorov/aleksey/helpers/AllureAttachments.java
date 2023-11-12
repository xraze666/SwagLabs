package sidorov.aleksey.helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;


public class AllureAttachments {
    @Attachment(value = "{attachName}", type = "image/jpeg")
    public static byte[] addScreenshotAs(String attachName){
        return Selenide.screenshot(OutputType.BYTES);
    }

}
