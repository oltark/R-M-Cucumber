package CucumberSteps;


import io.cucumber.java.ru.*;
import StepsRM.StepsRM;


public class CucumberSteps {

    @Когда("^Находим id персонажа")
    public void getCharacter() {
        StepsRM.getCharacter("2");

    }
    @То("^Находим урл с последним эпизодом")
    public void getLastEpisodeUrl() {
        StepsRM.getEpisodeUrl();
    }

    @И ("^Находим расу Морти")
    public void getMortyInfo() {
        StepsRM.getMortyRace();
    }

    @И ("^Находим локацию Морти")
    public void getMortyLoc() {
        StepsRM.getMortyLocation();
    }

    @Когда ("^Находим урл с последним персонажем")
    public void getLastCharacterUrl() {
        StepsRM.getLastCharUrl();
    }

    @То ("^Находим имя последнего персонажа в последнем эпизоде")
    public void getLastCharacterName() {
        StepsRM.getLastCharacter();
    }

    @И ("^Находим расу последнего персонажа")
    public void getLastCharRace() {
        StepsRM.getLastCharacterRace();
    }

    @И ("^Находим локацию последнего персонажа")
    public void getLastCharLocation() {
        StepsRM.getLastCharacterLocation();
    }


    @И ("^Проверка совпадения расы")
    public void getRaceAssert() {
        StepsRM.raceAssert();
    }

    @И ("^Проверка совпадения локации")
    public void getLocationAssert() {
        StepsRM.locationAssert();
    }







}
