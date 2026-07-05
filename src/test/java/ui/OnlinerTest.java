package ui;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class OnlinerTest {

    @Test
    public void checkWeatherOnliner() {
        when()
                .get("https://profile.onliner.by/sdapi/pogoda/api/now")
                .then()
                .log().all()
                .statusCode(200)
                .body("city", equalTo("Минске"))
                .body("temperature", equalTo("+23"))
                .body("icon", equalTo("A7"));
    }

    @Test
    public void checkLogin() {
        given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "\"page\": \"https://pogoda.onliner.by/\", \n" +
                        "\"login\": \"\", \n" +
                        "\"password\": \"Test\"\n" +
                        "}")
                .log().all()
                .when()
                .post("https://profile.onliner.by/sdapi/user.api/login")
                .then()
                .log().all()
                .statusCode(422)
                .body("message", equalTo("Validation failed"));
    }
}
