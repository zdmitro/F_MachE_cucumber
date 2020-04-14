package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.RegistrationPage;

import static java.lang.System.currentTimeMillis;

public class RegistrationSD {

    private final RegistrationPage page = new RegistrationPage();

    @Then("^Execute registration with 'Firs name' (.+), 'Last name' (.+), 'Email' (.+), 'password' (.+)$")
    public void executeRegistrationWithData(String firstName, String lastName, String email, String password) {
        long currentTime = currentTimeMillis();
        firstName = "Name" + currentTime;
        lastName = "Lastname" + currentTime;
        email = currentTime + "@test.test";
        password = "dmss111278DAP***";

        page.writeText(page.getFirstName(), firstName);
        page.writeText(page.getLastName(), lastName);
        page.writeText(page.getEmail(), email);
        page.writeText(page.getPassword(), password);
        page.click(page.getSubmitBtn());
    }

    @And("^On Registration page click on button (.+)$")
    public void onRegistrationPageClickOnButtonCreateAccount(String button) {
        switch (button) {
            case "Create Account":
                page.click(page.getSubmitBtn());
        }
    }
}