package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import stepDefinitions.SharedSD;
import utils.PropertiesReader;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class BasePage {

    private WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), TIMEOUT, POLLING);
    private static final int TIMEOUT = 15;
    private static final int POLLING = 100;
    private PropertiesReader propertiesReader = new PropertiesReader();

    public PropertiesReader getPropertiesReader() {
        return propertiesReader;
    }

    //wait visibility
    public void waitVisibility(By elementBy) {
        WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), TIMEOUT, POLLING);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitElementToBeClickable(By elementBy) {
        WebDriverWait wait = new WebDriverWait(SharedSD.getDriver(), TIMEOUT, POLLING);
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void clickByJSE(By elementBy) {
        JavascriptExecutor executor = (JavascriptExecutor) SharedSD.getDriver();
        executor.executeScript("arguments[0].click();", elementBy);
    }

    public boolean isElementDisplayed(By elementBy) {
        waitUntilElementDisplay(elementBy);
        return SharedSD.getDriver().findElement(elementBy).isDisplayed();
    }

    private void waitUntilElementDisplay(By elementBy) {
        int counter = 0;
        // System.out.println(counter);
        while (true) {
            try {
                counter++;
//                System.out.println(counter);
                SharedSD.getDriver().findElement(elementBy); //NoSuchElementException
                break;
            } catch (NoSuchElementException e) {
//                System.out.println(counter + "-> Element" + elementBy.toString() + " not found!");
                if (counter > 1000) {
                    break;
                }
            }
        }
        waitVisibility(elementBy);
    }

    /**
     * Get current URL
     */

    public String getCurrentURL(By elementBy) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().getCurrentUrl();
    }

    //click
    public void click(By elementBy) {
        waitUntilElementDisplay(elementBy);
        SharedSD.getDriver().findElement(elementBy).click();
    }


    //write text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        SharedSD.getDriver().findElement(elementBy).sendKeys(text);
    }

    //read text
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getText();
    }

    public String goToByElementAndReadText(By elementBy) {
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", elementBy);
        return SharedSD.getDriver().findElement(elementBy).getText();
    }

    public String goToWebElementAndReadText(WebElement webElement) {
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return webElement.getText();
    }

    //scrolls
    public void scrollByValues(String from, String to) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(" + from + ", " + to + ")");
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(0,2000)", "");
    }

    public void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window.scrollBy(0,2000)", "");
    }

    public void scrollElement(By elementBy) {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", elementBy);
    }

    //read Attribute
    public String readAttribute(By elementBy, String attribute) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getAttribute(attribute);
    }

    //read CssValue
    public String readCSSValue(By elementBy, String style) {
        waitVisibility(elementBy);
        return SharedSD.getDriver().findElement(elementBy).getCssValue(style);
    }

    //assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void waitForElementToAppear(By elementBy) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitForElementToDisappear(By elementBy) {
        this.wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    public void waitForTextToDisappear(By elementBy, String text) {
        this.wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(elementBy, text)));
    }

    public void assertElementsDisplayed(List<By> byList) {

        boolean isElementDisplayed = true;
        WebElement element;
        for (By e : byList) {
            try {
                element = SharedSD.getDriver().findElement(e);
            } catch (NoSuchElementException ex) {
                System.out.println(e + " - not found");
                isElementDisplayed = false;
                //break
            }
        }
        Assert.assertTrue(isElementDisplayed);
    }

    public void clearField(By elementBy) {
        waitVisibility(elementBy);
        SharedSD.getDriver().findElement(elementBy).clear();
    }

    public List<WebElement> getItemsFromContainer(By parentElementBy, By childElementBy) {
        waitVisibility(parentElementBy);
        return SharedSD.getDriver().findElement(parentElementBy).findElements(childElementBy);
    }

    public List<WebElement> getItemsByClassName(By elementBy) {
        //waitVisibility(elementBy);
        return SharedSD.getDriver().findElements(elementBy);
    }

    public List<WebElement> getItemsByClassNameStr(String className) {
        //waitVisibility(elementBy);
        return SharedSD.getDriver().findElements(By.className(className));
    }

    public void selectItem(String trim, By elementByClassName, By itemHeader, By btnSelect, By btnNext) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> itemsByClassName = this.getItemsByClassName(elementByClassName);

        WebElement webElement = itemsByClassName.stream()
                .filter(e -> trim.equals(e.findElement(itemHeader).getText()))
                .findFirst()
                .orElse(null);

        if (webElement == null) {
            System.out.println(webElement);
            while (webElement == null) {
                List<WebElement> btnNextList = this.getItemsByClassName(btnNext);
                btnNextList.get(0).click();

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                itemsByClassName = this.getItemsByClassName(elementByClassName);

                webElement = itemsByClassName.stream()
                        .filter(e -> trim.equals(e.findElement(itemHeader).getText()))
                        .findFirst()
                        .orElse(null);
            }

        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement element = webElement.findElement(btnSelect);
        ((JavascriptExecutor) SharedSD.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement.findElement(btnSelect));
//        System.out.println(element.getText());
        webElement.findElement(btnSelect).click();
    }

    public List<WebElement> getElementsByTag(String tag) {
        return SharedSD.getDriver().findElements(By.tagName(tag));
    }

    public List<WebElement> getElementsByText(String text) {
        return SharedSD.getDriver().findElements(By.xpath("//*[text() = '" + text + "']"));
    }

    public void switchTabsUsingPartOfUrl(String platform) {
        String currentHandle = "";
        String currentURL = "";
        try {
            final Set<String> handles = SharedSD.getDriver().getWindowHandles();
            if (handles.size() > 1) {
                currentHandle = SharedSD.getDriver().getWindowHandle();
            }
            if (currentHandle != null) {



                for (final String handle : handles) {
                    SharedSD.getDriver().switchTo().window(handle);
                    currentURL = SharedSD.getDriver().getCurrentUrl();
                    if (currentURL.contains(platform)) {
                        break;
                    }
                }
            } else {
                for (final String handle : handles) {
                    SharedSD.getDriver().switchTo().window(handle);
                    if (currentURL.contains(platform)) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Switching tabs failed");
        }
        currentURL = null;
    }

    public void switchToNewTab() {
        try {

            Set<String> tab_handles = SharedSD.getDriver().getWindowHandles();
            int number_of_tabs = tab_handles.size();
            int new_tab_index = number_of_tabs - 1;
            SharedSD.getDriver().switchTo().window(tab_handles.toArray()[new_tab_index].toString());

        } catch (Exception e) {
            System.out.println("Switching tabs failed");
        }
    }

    public String getCSSValue(By element, String style) {
        return SharedSD.getDriver().findElement(element).getCssValue(style);
    }

}