package asserts;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pageObjects.SelectBatteryAndPowertrainPage;
import pageObjects.SelectMachEModelPage;
import stepDefinitions.SharedSD;
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

    public void assertValidateThatBatteryAndPowertrainPageIsOpenedWithPricePrice(String expectedPrice) {
//        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", By.xpath("//*[text()='" + expectedPrice + "']"));
        String actualPrice = getDriver().findElement(By.xpath("//*[text()='" + expectedPrice + "']")).getText();
        Assert.assertEquals(expectedPrice, actualPrice);
    }
}
