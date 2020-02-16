package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static stepDefinitions.SharedSD.getDriver;

public class SelectBatteryAndPowertrainPage extends BasePage {
    SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();

    private final By tagSelectBatteryAndPowertrain = By.className("MainNavigation__StepDescription-kv0lv4-7");

    private final By selectMSRP = By.className("ProductTile__AttributeValue-sc-8r7rba-14");

    public void goToSelectBatteryAndPowertrain(String trim) {

    }


    public By getTagSelectBatteryAndPowertrain() {
        return tagSelectBatteryAndPowertrain;
    }

    public By getSelectMSRP() {
        return selectMSRP;
    }
}
