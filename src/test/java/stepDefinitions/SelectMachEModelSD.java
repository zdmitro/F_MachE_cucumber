package stepDefinitions;

import asserts.SelectMachEModelAssert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import pageObjects.SelectBatteryAndPowertrainPage;
import pageObjects.SelectMachEModelPage;
import utils.PropertiesReader;

import java.util.List;

public class SelectMachEModelSD {
    private final PropertiesReader pr = new PropertiesReader();
    private final SelectMachEModelAssert selectMachEModelAssert = new SelectMachEModelAssert();
    private final SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();
    private final SelectBatteryAndPowertrainPage selectBatteryAndPowertrainPage = new SelectBatteryAndPowertrainPage();

    @Given("^Select Mustang Mach-e Page is opened$")
    public void SelectMachEModelPageIsOpened() {
        this.selectMachEModelAssert.assertByUrlSelectMachEModelPageIsOpened();
    }

    @Then("^Assert Select Model Page is Opened$")
    public void assertSelectModelPageIsOpened() {
        this.selectMachEModelAssert.assertMachEModelTrim();
    }

    @Then("^Assert Elements Are Present in the Body$")
    public void assertElementsArePresentInTheBody() {
        this.selectMachEModelAssert.assertElementsArePresentInTheBody();
    }

    @Then("^Assert (\\d+) Cards Are Present in the Body$")
    public void assertCardsArePresentInTheBody(int count) {
        this.selectMachEModelAssert.assertCardsArePresentInTheBody( count);
    }

    @Then("^Validate that each card contain all the elements$")
    public void assertThatEachCardContainAllTheElements() {
        this.selectMachEModelAssert.assertThatEachCardContainAllTheElements();
    }

    @Then("^Validate that text is present and correct in the body of a card$")
    public void assertThatTextIsPresentAndCorrectInTheBodyOfACard() {
        this.selectMachEModelAssert.assertThatTextIsPresentAndCorrectInTheBodyOfACard();
    }

    @When("^Select button for (.+) trim is clicked$")
    public void selectButtonForTrimTrimIsClicked(String trim) {
        List<WebElement> itemsByClassName = this.selectMachEModelPage.getItemsByClassName(this.selectMachEModelPage.getBtnSelect());
//        itemsByClassName.stream()
//                .filter(e -> trim.equals(e.getText()))
    }
}
