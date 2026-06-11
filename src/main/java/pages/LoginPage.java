package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.shadowCss;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static dict.Elements.SIGN_IN;

public class LoginPage {

    private final String LOGIN = "[name=email]";
    private final String PASSWORD = "[name=password]";

    @Step("Открыть страницу логина")
    public LoginPage openPage() {
        open("/login");
        return this;
    }

    @Step("Авторизоваться своим юзером")
    public ProjectsPage login(String user, String password) {
        $(shadowCss("#accept", "#usercentrics-cmp-ui")).click();
        $(LOGIN).setValue(user);
        $(PASSWORD).setValue(password);
        $(byText(SIGN_IN)).click();
        return new ProjectsPage();
    }
}
