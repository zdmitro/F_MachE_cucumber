package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import stepDefinitions.SharedSD;

import java.util.List;

import static stepDefinitions.SharedSD.getDriver;

public class SelectBatteryAndPowertrainPage extends BasePage {
    SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();

    private final By tagSelectBatteryAndPowertrain = By.className("MainNavigation__StepDescription-kv0lv4-7");

    private final By selectMSRP = By.className("ProductTile__AttributeValue-sc-8r7rba-14");

    private final By coockiesCloseButton = By.xpath("/html/body/div[7]/div[3]/div/div/div[3]/a");
//    attributeValue is some variable text on the page, including the price
    private final By attributeValue = By.className("ProductTile__AttributeValue-sc-8r7rba-14");
//    Select Button for GT Trim -> Select Battery and Powertrain
    private final By btnSelectPowertrain = By.className("Button__ButtonCommon-sc-5scy24-0");

    private final By containerItemPowertrain = By.className("ProductTileSection__ProductTileSectionInner-sc-1a04xx1-8");

    private final By headerH2Powertrain = By.className("ProductTile__Header-sc-8r7rba-0");

    private final By btnNextPowertrain = By.className("ProductTileSection__TileButtonNext-sc-1a04xx1-6");



    public void goToSelectBatteryAndPowertrain(String trim) {

    }


    public By getTagSelectBatteryAndPowertrain() {
        return tagSelectBatteryAndPowertrain;
    }

    public By getSelectMSRP() {
        return selectMSRP;
    }

    public By getCoockiesCloseButton() {
        return coockiesCloseButton;
    }

    public By getAttributeValue() {
        return attributeValue;
    }

    public By getBtnSelectPowertrain() {
        return btnSelectPowertrain;
    }

    public By getContainerItemPowertrain() {
        return containerItemPowertrain;
    }

    public By getHeaderH2Powertrain() {
        return headerH2Powertrain;
    }

    public By getBtnNextPowertrain() {
        return btnNextPowertrain;
    }

    //    public void clickSelect() {
//
//        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", getBtnSelect());
////        System.out.println(element.getText());
////        scrollElement(getBtnSelect());
//        click(getBtnSelect());
//    }


}
