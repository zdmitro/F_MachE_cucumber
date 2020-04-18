package asserts;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pageObjects.SignInPage;
import stepDefinitions.SharedSD;
import utils.FileService;
import utils.PropertiesReader;

import static stepDefinitions.SharedSD.getDriver;

public class SignInAssert {

    private final PropertiesReader pr = new PropertiesReader();
    private final SignInPage page = new SignInPage();

    public void assertAuthPageIsOpened() {
        try {
            this.page.click(this.page.getCoockiesCloseBtn());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookies bar not found!");
        }
        Assert.assertEquals(getDriver().getCurrentUrl(), pr.getUrlAuth());
    }

    public void assertYourdetailsPageIsOpened(String firstName, String lastName, String email, String password) {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, pr.getUrlYourDetails());
        new FileService(pr.getRegFilePath()).write(firstName, lastName, email, password);
    }
}
