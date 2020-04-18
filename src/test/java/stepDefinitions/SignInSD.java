package stepDefinitions;

import cucumber.api.java.en.When;
import pageObjects.SignInPage;

public class SignInSD {

    private final SignInPage page = new SignInPage();

    @When("^On SignIn page click on button (.+)$")
    public void clickOnButtonCreateAnAccount(String button) {
        switch (button) {
            case "Icon eye":
                break;
            case "Sign In":
                break;
            case "Forgot Password?":
                break;
            case "Create an Account":
                page.click(page.getCreateAccountBtn());
                break;
            case "Go Back":
                break;
        }
    }
}
