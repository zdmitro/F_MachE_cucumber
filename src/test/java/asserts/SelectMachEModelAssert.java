package asserts;

import expected.SelectBatteryAndPowertrainExp;
import expected.SelectMachEModelExp;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
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

        try {
            this.selectMachEModelPage.click(this.selectMachEModelPage.getCoockiesCloseButton());
        } catch (NoSuchElementException e) {
            System.out.println("Cookies bar not found!");
        }
        Assert.assertEquals(getDriver().getCurrentUrl(), pr.getUrl());
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

    public void assertThatTextIsPresentAndCorrectInTheBodyOfSelectCard() {
        List<WebElement> h2Elemments = getDriver().findElements(this.selectMachEModelPage.getTagH2());
        List<WebElement> spanElements = getDriver().findElements(this.selectMachEModelPage.getTagSpan());
        List<WebElement> h3Elements = getDriver().findElements(this.selectMachEModelPage.getTagH3());
        List<WebElement> liElements = getDriver().findElements(this.selectMachEModelPage.getTagLi());

        Assert.assertEquals(h2Elemments.get(0).getText(), "SELECT");
        Assert.assertEquals(spanElements.get(3).getText(),"Est. MSRP Starting At");
        Assert.assertEquals(spanElements.get(4).getText(),"$43,895");
        Assert.assertEquals(spanElements.get(6).getText(),"Available");
        Assert.assertEquals(spanElements.get(7).getText(),"Early 2021");
        Assert.assertEquals(spanElements.get(10).getText(),"Not Including $7,500 Federal Tax Credit");
        Assert.assertEquals(h3Elements.get(3).getText(),"Key Features");
        Assert.assertEquals(liElements.get(1).getText(),"18\" Aluminum Wheels");
        Assert.assertEquals(liElements.get(2).getText(),"Next Generation SYNC® with Connected Navigation");
        Assert.assertEquals(liElements.get(3).getText(),"Phone as a Key");
        Assert.assertEquals(liElements.get(4).getText(),"10.2\" Digital Cluster & 15.5\" Touch Screen");
        Assert.assertEquals(liElements.get(5).getText(),"Ford Co-Pilot360™ 2.0 + Co-Pilot 360™ Assist 2.0");
        Assert.assertEquals(liElements.get(6).getText(),"LED Lights and Sequential Rear Turn Signals");

    }

    public void assertElementsArePresentInTheBody() {
        //Main Container
        Assert.assertTrue(this.selectMachEModelPage.isElementDisplayed(this.selectMachEModelPage.getProductContainer()));

    }

    public void assertCardsArePresentInTheBody(int count) {
        Assert.assertEquals(count, this.selectMachEModelPage.getItemsFromContainer(this.selectMachEModelPage.getProductContainer(), this.selectMachEModelPage.getProductContainerItem()).size());
    }

    public void assertThatEachCardContainAllTheElements() {
        List<WebElement> itemsFromContainer = this.selectMachEModelPage.getItemsFromContainer(this.selectMachEModelPage.getProductContainer(), this.selectMachEModelPage.getProductContainerItem());
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

    public void assertThatTextIsPresentAndCorrectInTheBodyOfPREMIUMCard() {
        List<WebElement> h2Elemments = getDriver().findElements(this.selectMachEModelPage.getTagH2());
        List<WebElement> spanElements = getDriver().findElements(this.selectMachEModelPage.getTagSpan());
        List<WebElement> h3Elements = getDriver().findElements(this.selectMachEModelPage.getTagH3());
        List<WebElement> liElements = getDriver().findElements(this.selectMachEModelPage.getTagLi());

        Assert.assertEquals(h2Elemments.get(1).getText(), "PREMIUM");

        Assert.assertEquals(spanElements.get(12).getText(),"Est. MSRP Starting At");
        Assert.assertEquals(spanElements.get(13).getText(),"$50,600");
        Assert.assertEquals(spanElements.get(15).getText(),"Available");
        Assert.assertEquals(spanElements.get(16).getText(),"Late 2020");
        Assert.assertEquals(spanElements.get(19).getText(),"Not Including $7,500 Federal Tax Credit");
        Assert.assertEquals(h3Elements.get(4).getText()," SELECT Features Plus");
        Assert.assertEquals(liElements.get(8).getText(),"19\" Aluminum Wheels");
        Assert.assertEquals(liElements.get(9).getText(),"Handsfree, Foot Activated Liftgate");
        Assert.assertEquals(liElements.get(10).getText(),"Panoramic Fixed-Glass Roof");
        Assert.assertEquals(liElements.get(11).getText(),"Heated First Row Seats");
        Assert.assertEquals(liElements.get(12).getText(),"Heated Steering Wheel");
        Assert.assertEquals(liElements.get(13).getText(),"Memory Driver Seats & Power Folding Mirrors");
        Assert.assertEquals(liElements.get(14).getText(),"Active Park Assist 2.0");
        Assert.assertEquals(liElements.get(15).getText(),"360 Degree Camera");
        Assert.assertEquals(liElements.get(16).getText(),"B&O 10-Speaker Sound System");

    }

    public void assertThatTextIsPresentAndCorrectInTheBodyOfCALIFORNIARTEDITIONCard() {

        List<WebElement> h2Elemments = getDriver().findElements(this.selectMachEModelPage.getTagH2());
        List<WebElement> spanElements = getDriver().findElements(this.selectMachEModelPage.getTagSpan());
        List<WebElement> h3Elements = getDriver().findElements(this.selectMachEModelPage.getTagH3());
        List<WebElement> liElements = getDriver().findElements(this.selectMachEModelPage.getTagLi());

        Assert.assertEquals(h2Elemments.get(2).getText(), "CALIFORNIA RT.1 EDITION");

        Assert.assertEquals(spanElements.get(21).getText(),"Est. MSRP Starting At");
        Assert.assertEquals(spanElements.get(22).getText(),"$52,400");
        Assert.assertEquals(spanElements.get(24).getText(),"Available");
        Assert.assertEquals(spanElements.get(25).getText(),"Early 2021");
        Assert.assertEquals(spanElements.get(28).getText(),"Not Including $7,500 Federal Tax Credit");
        Assert.assertEquals(h3Elements.get(5).getText()," SELECT Features Plus");
        Assert.assertEquals(liElements.get(18).getText(),"18\" Aluminum Wheels with Aero Inserts");
        Assert.assertEquals(liElements.get(19).getText(),"Unique California Route 1 Badging");
        Assert.assertEquals(liElements.get(20).getText(),"Panoramic Fixed-Glass Roof");
        Assert.assertEquals(liElements.get(21).getText(),"Memory Driver Seats & Power Folding Mirrors");
        Assert.assertEquals(liElements.get(22).getText(),"360 Degree Camera");
        Assert.assertEquals(liElements.get(23).getText(),"Active Park Assist 2.0");

    }

    public void assertThatTextIsPresentAndCorrectInTheBodyOfGTCard() {
        List<WebElement> h2Elemments = getDriver().findElements(this.selectMachEModelPage.getTagH2());
        List<WebElement> spanElements = getDriver().findElements(this.selectMachEModelPage.getTagSpan());
        List<WebElement> h3Elements = getDriver().findElements(this.selectMachEModelPage.getTagH3());
        List<WebElement> liElements = getDriver().findElements(this.selectMachEModelPage.getTagLi());

        Assert.assertEquals(h2Elemments.get(3).getText(), "GT");

        Assert.assertEquals(spanElements.get(30).getText(),"Est. MSRP Starting At");
        Assert.assertEquals(spanElements.get(31).getText(),"$60,500");
        Assert.assertEquals(spanElements.get(33).getText(),"Available");
        Assert.assertEquals(spanElements.get(34).getText(),"Spring 2021");
        Assert.assertEquals(spanElements.get(37).getText(),"Not Including $7,500 Federal Tax Credit");
        Assert.assertEquals(h3Elements.get(6).getText(),"Key Features");
        Assert.assertEquals(liElements.get(25).getText(),"20\" Cast Aluminum Wheels");
        Assert.assertEquals(liElements.get(26).getText(),"Permanent-Electric Dual Motor All Wheel Drive");
        Assert.assertEquals(liElements.get(27).getText(),"Miko® Inserts & Copper Metallic Stitching");
        Assert.assertEquals(liElements.get(28).getText(),"B&O 10-Speaker Sound System");
        Assert.assertEquals(liElements.get(29).getText(),"Handsfree, Foot Activated Liftgate");
        Assert.assertEquals(liElements.get(30).getText(),"Memory Driver Seats & Power Folding Mirrors");

    }

    public void validateThatAllElementsArePresentOnTheTopBar() {
        List<WebElement> itemsFromContainer = this.selectMachEModelPage.getItemsFromContainer(this.selectMachEModelPage.getProductContainer(), this.selectMachEModelPage.getProductContainerItem());

    }
}
