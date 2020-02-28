package stepDefinitions;

import asserts.SelectBatteryAndPowertrainAssert;
import asserts.SelectMachEModelAssert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import pageObjects.SelectBatteryAndPowertrainPage;
import pageObjects.SelectMachEModelPage;
import utils.PropertiesReader;

public class SelectBatteryAndPowertrainSD {
    private final PropertiesReader pr = new PropertiesReader();
    private final SelectMachEModelAssert selectMachEModelAssert = new SelectMachEModelAssert();
    private final SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();
    private final SelectBatteryAndPowertrainPage selectBatteryAndPowertrainPage = new SelectBatteryAndPowertrainPage();
    private final SelectBatteryAndPowertrainAssert selectBatteryAndPowertrainAssert = new SelectBatteryAndPowertrainAssert();

//    @Then("^Validate that text is present and correct in the body of a card$")
//    public void validateBatteryAndPowertrainPage() {
//        this.selectMachEModelAssert.assertElementsArePresentInTheBody();
//    }

    @Then("^Validate that Battery and Powertrain Page is Opened for Select trim$")
    public void assertThatBatteryAndPowertrainPageIsOpenedForSelectTrim() {
        this.selectBatteryAndPowertrainAssert.assertThatBatteryAndPowertrainPageIsOpenedForSelectTrim();
    }

    @Then("^Validate that Battery and Powertrain Page is Opened with price (.+)$")
    public void validateThatBatteryAndPowertrainPageIsOpenedWithPricePrice(String price) {
        this.selectBatteryAndPowertrainAssert.assertValidateThatBatteryAndPowertrainPageIsOpenedWithPricePrice(price);
    }

    @Then("^Select button for Extended Range Battery - (.+) is clicked$")
    public void selectButtonForExtendedRangeBatteryAWDIsClicked(String text) {
        this.selectBatteryAndPowertrainPage.selectItem(
                text,
                this.selectBatteryAndPowertrainPage.getContainerItemPowertrain(),
                this.selectBatteryAndPowertrainPage.getHeaderH2Powertrain(),
                this.selectBatteryAndPowertrainPage.getBtnSelectPowertrain(),
                this.selectBatteryAndPowertrainPage.getBtnNextPowertrain()

        );
        this.selectBatteryAndPowertrainPage.scrollDown("");
    }
}
