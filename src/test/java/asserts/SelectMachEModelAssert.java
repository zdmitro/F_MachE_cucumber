package asserts;

import expected.SelectBatteryAndPowertrainExp;
import expected.SelectMachEModelExp;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.SelectMachEModelPage;
import stepDefinitions.SharedSD;
import utils.PropertiesReader;

import java.util.List;

import static stepDefinitions.SharedSD.getDriver;

public class SelectMachEModelAssert {
    private final PropertiesReader pr = new PropertiesReader();
    private final SelectMachEModelPage selectMachEModelPage = new SelectMachEModelPage();

    public void assertByUrlSelectMachEModelPageIsOpened() {

        if(this.selectMachEModelPage.isElementDisplayed(this.selectMachEModelPage.getCoockiesBanner())) {
            this.selectMachEModelPage.click(this.selectMachEModelPage.getCoockiesCloseButton());
        }

        Assert.assertEquals(getDriver().getCurrentUrl(), pr.getUrl());
    }

    public void assertByHeaderSelectMachEModelPageIsOpened() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(this.selectMachEModelPage.isElementDisplayed(this.selectMachEModelPage.getHeaderSelect()));
//        Assert.assertTrue(this.selectMachEModelPage.isElementDisplayed(this.selectMachEModelPage));
//        Assert.assertEquals("SELECT", this.selectMachEModelPage.readText(this.selectMachEModelPage.getHeaderSelect()));

    }

    /**
     * assert verifies ????
     */
    public void assertMachEModelTrim() {
        List<WebElement> elements = getDriver().findElements(this.selectMachEModelPage.getTagH2());
        Assert.assertEquals(SelectBatteryAndPowertrainExp.expTrimsHeaderList.get(0), elements.get(0).getText());
        Assert.assertEquals(SelectBatteryAndPowertrainExp.expTrimsHeaderList.get(1), elements.get(1).getText());
        Assert.assertEquals(SelectBatteryAndPowertrainExp.expTrimsHeaderList.get(2), elements.get(2).getText());
        Assert.assertEquals(SelectBatteryAndPowertrainExp.expTrimsHeaderList.get(3), elements.get(3).getText());
    }

    public void assertThatTextIsPresentAndCorrectInTheBodyOfACard() {
        List<WebElement> elements = getDriver().findElements(this.selectMachEModelPage.getTagSpan());
        Assert.assertEquals(elements.get(3).getText(),"Est. MSRP Starting At");
        Assert.assertEquals(elements.get(4).getText(),"$43,895");
        Assert.assertEquals(elements.get(6).getText(),"Available");
        Assert.assertEquals(elements.get(7).getText(),"Early 2021");
        Assert.assertEquals(elements.get(12).getText(),"Targeted EPA-Estimated Range");
        Assert.assertEquals(elements.get(13).getText(),"230 miles");
        Assert.assertEquals(elements.get(15).getText(),"Target Range up to");
        Assert.assertEquals(elements.get(16).getText(),"230 miles");

    }

    public void assertElementsArePresentInTheBody() {
        //Main Container
        Assert.assertTrue(this.selectMachEModelPage.isElementDisplayed(this.selectMachEModelPage.getProductContainer()));

    }

    public void assertCardsArePresentInTheBody(int count) {
        Assert.assertEquals(count, this.selectMachEModelPage.getItemsFromContainer(this.selectMachEModelPage.getProductContainer(), this.selectMachEModelPage.getProductCotainerItem()).size());
    }

    public void assertThatEachCardContainAllTheElements() {
        List<WebElement> itemsFromContainer = this.selectMachEModelPage.getItemsFromContainer(this.selectMachEModelPage.getProductContainer(), this.selectMachEModelPage.getProductCotainerItem());
        itemsFromContainer.forEach(e -> {
            System.out.println(e);
            e.findElement(this.selectMachEModelPage.getImgCardCarBackground()).isDisplayed();
            e.findElement(this.selectMachEModelPage.getImgCardCarFront()).isDisplayed();
            e.findElement(this.selectMachEModelPage.getBtnCardToFullScreen()).isDisplayed();
            e.findElement(this.selectMachEModelPage.getBtnSelect()).isDisplayed();
            e.findElement(this.selectMachEModelPage.getHeaderTrim()).isDisplayed();
            e.findElement(this.selectMachEModelPage.getHeaderFeatures()).isDisplayed();
        });

    }
}
