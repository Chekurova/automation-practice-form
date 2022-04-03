package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
    @BeforeAll
    static void setUp(){
        // Add log
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        // browser configurations
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize =  "1512x810";
        // remote browsers setup
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        // remote setup start
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
