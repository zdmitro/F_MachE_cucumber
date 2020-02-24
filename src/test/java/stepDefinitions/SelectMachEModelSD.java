package stepDefinitions;

import asserts.SelectMachEModelAssert;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.SelectBatteryAndPowertrainPage;
import pageObjects.SelectMachEModelPage;
import utils.PropertiesReader;

import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

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

    @Then("^Validate that text is present and correct in the body of SELECT card$")
    public void assertThatTextIsPresentAndCorrectInTheBodyOfSELECTCard() {
        this.selectMachEModelAssert.assertThatTextIsPresentAndCorrectInTheBodyOfSelectCard();
    }

    @When("^Select button for (.+) trim is clicked$")
    public void selectButtonForTrimTrimIsClicked(String trim) {
        List<WebElement> itemsByClassName = this.selectMachEModelPage.getItemsByClassName(this.selectMachEModelPage.getProductCotainerItem());

        WebElement webElement = itemsByClassName.stream()
                .filter(e -> trim.equals(e.findElement(this.selectMachEModelPage.getHeaderTagH2()).getText()))
                .findFirst()
                .orElse(null);

        if (webElement == null) {
            List<WebElement> btnNextList = this.selectMachEModelPage.getItemsByClassName(this.selectMachEModelPage.getBtnNext());
            btnNextList.get(0).click();
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            itemsByClassName = this.selectMachEModelPage.getItemsByClassName(this.selectMachEModelPage.getProductCotainerItem());
            webElement = itemsByClassName.get(itemsByClassName.size() - 1);
        }
        webElement.findElement(this.selectMachEModelPage.getBtnSelect()).click();
    }

    public void selectItem(String trim, By byClassName, By itemHeader) {
        List<WebElement> itemsByClassName = this.selectMachEModelPage.getItemsByClassName(byClassName);

        WebElement webElement = itemsByClassName.stream()
                .filter(e -> trim.equals(e.findElement(itemHeader).getText()))
                .findFirst()
                .orElse(null);

    }

    @Then("^Validate that text is present and correct in the body of PREMIUM card$")
    public void assertThatTextIsPresentAndCorrectInTheBodyOfPREMIUMCard() {
        this.selectMachEModelAssert.assertThatTextIsPresentAndCorrectInTheBodyOfPREMIUMCard();
    }

    @Then("^Validate that text is present and correct in the body of CALIFORNIA RT 1 EDITION card$")
    public void assertThatTextIsPresentAndCorrectInTheBodyOfCALIFORNIARTEDITIONCard() {
        this.selectMachEModelAssert.assertThatTextIsPresentAndCorrectInTheBodyOfCALIFORNIARTEDITIONCard();
    }

    @Then("^Validate that text is present and correct in the body of GT card$")
    public void assertThatTextIsPresentAndCorrectInTheBodyOfGTCard() {
        this.selectMachEModelAssert.assertThatTextIsPresentAndCorrectInTheBodyOfGTCard();
    }

    @Then("^Validate that all elements are present on the top bar$")
    public void validateThatAllElementsArePresentOnTheTopBar() {
        this.selectMachEModelAssert.validateThatAllElementsArePresentOnTheTopBar();

    }
}
