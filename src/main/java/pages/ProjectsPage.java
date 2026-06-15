package pages;

import dict.Elements;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ProjectsPage {

    private final String ACTION_MENU = "button[aria-label='Open action menu']";
    private final String REMOVE_BUTTON = "[data-testid='remove']";
    private final String CONFIRM_DELETE_BUTTON = "//span[text()='Delete project']";

    public void openPage() {
        open("/projects");
    }

    public ProjectPage clickCreateProject() {
        $(byText(Elements.CREATE_NEW_PROJECT)).click();
        return new ProjectPage();
    }

    public ProjectsPage shouldNotHaveProject(String projectName) {
        $(byText(projectName)).shouldNot(exist);
        return this;
    }

    public ProjectsPage shouldHaveProject(String projectName) {
        $(byText(projectName)).shouldBe(visible);
        return this;
    }

    public ProjectsPage deleteProject(String projectName) {
        $(byText(projectName))
                .ancestor("tr")
                .find(ACTION_MENU)
                .click();
        $(REMOVE_BUTTON).click();
        $x(CONFIRM_DELETE_BUTTON).click();
        return this;
    }
}
