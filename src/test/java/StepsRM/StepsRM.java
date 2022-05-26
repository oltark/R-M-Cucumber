package StepsRM;

import io.cucumber.java.ru.И;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import java.util.ArrayList;
import static io.restassured.RestAssured.given;

public class StepsRM {


    private static final String baseURL = "https://rickandmortyapi.com/api/";

    public static String characterId;
    public static String lastEpisodeUrl;
    public static String mortyRace;
    public static String mortyLocation;
    public static String lastCharacterNameUrl;
    public static String lastCharacterName;
    public static String lastCharacterRace;
    public static String lastCharacterLocation;

    // Находим id персонажа

    public static void getCharacter(String id) {
        Response getCharacter = given()
                .baseUri(baseURL)
                .when()
                .get("/character/" + id)
                .then()
                .extract()
                .response();
        characterId = new JSONObject(getCharacter.getBody().asString()).get("id").toString();
    }

    // Находим URL с последним эпизодом, где появлялся Морти

    public static void getEpisodeUrl() {

        ArrayList episode = given()
                .baseUri(baseURL)
                .when()
                .contentType(ContentType.JSON)
                .get("/character/" + characterId)
                .then()
                .extract().body().jsonPath().get("episode");
        lastEpisodeUrl = episode.get(episode.size() - 1).toString();
        System.out.println("Последний эпизод, где появлялся Морти Смит - " + lastEpisodeUrl);
    }

    // Находим расу Морти

    public static void getMortyRace() {

        String getRace = given()
                .baseUri(baseURL)
                .when()
                .contentType(ContentType.JSON)
                .get("/character/" + characterId)
                .then()
                .extract().body().jsonPath().get("species").toString();
        mortyRace = getRace;
        System.out.println("Раса Морти - " + mortyRace);
    }

    //Находим локацию Морти

    public static void getMortyLocation() {
        String getMortyLoc = given()
                .baseUri(baseURL)
                .when()
                .contentType(ContentType.JSON)
                .get("/character/" + characterId)
                .then()
                .extract().body().jsonPath().get("location.name").toString();
        mortyLocation = getMortyLoc;
        System.out.println("Локация Морти - " + mortyLocation);
    }

    // Находим URL с последним персонажем в последнем эпизоде

    public static void getLastCharUrl() {
        ArrayList characters = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastEpisodeUrl)
                .then()
                .extract().body().jsonPath().get("characters");
        lastCharacterNameUrl = characters.get(characters.size() - 1).toString();
    }

    // Находим имя последнего персонажа в последнем эпизоде

    public static void getLastCharacter() {

        String getLastCharacterName = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastCharacterNameUrl)
                .then()
                .extract().body().jsonPath().get("name").toString();
        lastCharacterName = getLastCharacterName;

        System.out.println("Последний персонаж в последнем эпизоде - " + lastCharacterName);
    }

    //Находим расу последнего персонажа

    public static void getLastCharacterRace() {

        String getLastCharRace = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastCharacterNameUrl)
                .then()
                .extract().body().jsonPath().get("species").toString();
        lastCharacterRace = getLastCharRace;
        System.out.println("Раса последнего персонажа "+ lastCharacterName + " - "+ lastCharacterRace);
    }

    //Находим локацию последнего персонажа

    public static void getLastCharacterLocation() {

        Object getLastCharLocation = given()
                .when()
                .contentType(ContentType.JSON)
                .get(lastCharacterNameUrl)
                .then()
                .extract().body().jsonPath().get("location.name").toString();
        lastCharacterLocation = getLastCharLocation.toString();
        System.out.println("Локация последнего персонажа "+ lastCharacterName + " - "+ lastCharacterLocation);
    }

    // Проверка на совпадение расы последнего персонажа с расой Морти

    public static void raceAssert() {

        Assertions.assertEquals(mortyRace, lastCharacterRace, "Раса не совпадает");
    }

    // Проверка на совпадение локации последнего персонажа и Морти

    public static void locationAssert() {

        Assertions.assertEquals(mortyLocation, lastCharacterLocation, "Локация не совпадает");
    }


}
