package pageObjects;

import org.openqa.selenium.By;

public class SelectMachEModelPage extends BasePage {

    private final By headerSelect = By.xpath("/html/body/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div/div[1]/div/div[1]/div/h2");

//    Select Elements by html tag hs
    private final By tagH2 = By.tagName("h2");

    private final By productContainer = By.className("ProductTileSection__ProductTileSectionInner-sc-1a04xx1-8");
    private final By productCotainerItem = By.className("ProductTileSection__ProductTileFullWidthWrapper-sc-1a04xx1-1");

    private final By tagSpan = By.tagName("span");
    private final By btnCardToFullScreen = By.className("ProductTileSection__ProductTileExpand-sc-1a04xx1-0");
    private final By btnSelect = By.className("Button__ButtonCommon-sc-5scy24-0");
    private final By headerTrim = By.className("ProductTile__Header-sc-8r7rba-0");
    private final By headerFeatures = By.className("ProductTile__FeaturesHeader-sc-8r7rba-2");

    private final By imgCardCarBackground = By.className("ProductTile__VehicleBackgroundImage-sc-8r7rba-7");
    private final By imgCardCarFront = By.className("ProductTile__VehicleImage-sc-8r7rba-8");

    public By getTagH2() {
        return tagH2;
    }
//    private final By linkMustangMachE = By.


    public By getHeaderSelect() {
        return headerSelect;
    }

    public By getTagSpan() {
        return tagSpan;
    }

    public By getProductContainer() {
        return productContainer;
    }

    public By getProductCotainerItem() {
        return productCotainerItem;
    }

    public By getBtnCardToFullScreen() {
        return btnCardToFullScreen;
    }

    public By getBtnSelect() {
        return btnSelect;
    }

    public By getHeaderTrim() {
        return headerTrim;
    }

    public By getHeaderFeatures() {
        return headerFeatures;
    }

    public By getImgCardCarBackground() {
        return imgCardCarBackground;
    }

    public By getImgCardCarFront() {
        return imgCardCarFront;
    }


}


