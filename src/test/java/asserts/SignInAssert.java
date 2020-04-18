package asserts;

import org.junit.Assert;
import stepDefinitions.SharedSD;
import utils.FileService;
import utils.PropertiesReader;

import static stepDefinitions.SharedSD.getDriver;

public class SignInAssert {

    private final PropertiesReader pr = new PropertiesReader();

    public void assertAuthPageIsOpened() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Assert.assertEquals(getDriver().getCurrentUrl(), pr.getUrl());
    }

    public void assertYourdetailsPageIsOpened(String firstName, String lastName, String email, String password) {
        String currentUrl = getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, pr.getUrlYourDetails());
        new FileService(pr.getRegFilePath()).write(firstName, lastName, email, password);
    }
}
