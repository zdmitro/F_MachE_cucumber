package asserts;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObjects.SelectBatteryAndPowertrainPage;
import pageObjects.SelectMachEModelPage;
import utils.PropertiesReader;

import java.util.List;

import static stepDefinitions.SharedSD.getDriver;

public class SelectBatteryAndPowertrainAssert  {
    private final PropertiesReader pr = new PropertiesReader();
    private final SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();
    private final SelectBatteryAndPowertrainPage selectBatteryAndPowertrainPage = new SelectBatteryAndPowertrainPage();

    public void assertThatBatteryAndPowertrainPageIsOpenedForSelectTrim() {
        Assert.assertEquals("NOW SELECT YOUR BATTERY AND POWERTRAIN", this.selectBatteryAndPowertrainPage.readText(this.selectBatteryAndPowertrainPage.getTagSelectBatteryAndPowertrain()));
        List<WebElement> elements = getDriver().findElements(this.selectBatteryAndPowertrainPage.getSelectMSRP());
        Assert.assertEquals("$43,895", elements.get(0).getText());
    }
}
