package ui;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static dict.Elements.CREATE_NEW_PROJECT;
import static utils.PropertyReader.getProperty;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithPositiveCred() {
        loginPage.openPage();
        loginPage.login(
                getProperty("user"),
                getProperty("password")
        );
        webdriver().shouldHave(urlContaining("/projects"));
        $(byText(CREATE_NEW_PROJECT)).shouldBe(visible);
    }
}
