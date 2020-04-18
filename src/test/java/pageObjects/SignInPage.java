package pageObjects;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private final By coockiesCloseBtn = By.xpath("//*[@id='onetrust-close-btn-container']/button");
    private final By forgotPasswordBtn = By.id("forgot-password-btn");
    private final By createAccountBtn = By.id("create-account-btn");

    public By getForgotPasswordBtn() {
        return forgotPasswordBtn;
    }

    public By getCreateAccountBtn() {
        return createAccountBtn;
    }

    public By getCoockiesCloseBtn() {
        return coockiesCloseBtn;
    }
}