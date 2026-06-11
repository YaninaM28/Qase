package tests;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static utils.PropertyReader.getProperty;

public class ProjectTest extends BaseTest {

    private static String projectName = "TMS01";
    private static String projectCode = "TMS001";

    @Test(description = "Проверка создания нового проекта")
    @Description("Авторизоваться в Qase и создать новый проект")
    public void checkCreateProject() {

        loginPage.openPage()
                .login(
                        getProperty("user"),
                        getProperty("password"))
                .clickCreateProject()
                .setProjectName(projectName)
                .setProjectCode(projectCode)
                .clickCreateProject()
                .shouldHaveProject(projectName);
    }

    @Test(dependsOnMethods = "checkCreateProject")
    public void checkDeleteProject() {
        loginPage.openPage()
                .login(
                        getProperty("user"),
                        getProperty("password"))
                .deleteProject(projectName)
                .shouldNotHaveProject(projectName);
    }
}
