package stepDefinitions;

import asserts.SignInAssert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.RegistrationPage;
import utils.PropertiesReader;

import static java.lang.System.currentTimeMillis;

public class RegistrationSD {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private final PropertiesReader pr = new PropertiesReader();
    private final RegistrationPage page = new RegistrationPage();
    private final SignInAssert asserts = new SignInAssert();

    @Given("^Select Auth Page is opened$")
    public void SelectAuthPageIsOpened() {
        SharedSD.getDriver().get(pr.getUrlAuth());
        //this.asserts.assertAuthPageIsOpened();
    }

    @Then("^Execute registration with 'Firs name' (.+), 'Last name' (.+), 'Email' (.+), 'password' (.+)$")
    public void executeRegistrationWithData(String firstName, String lastName, String email, String password) {
        long currentTime = currentTimeMillis();
        this.firstName = firstName + currentTime;
        this.lastName = lastName + currentTime;
        this.email = "qwerty" + currentTime + email;
        this.password = password;

        page.writeText(page.getFirstName(), this.firstName);
        page.writeText(page.getLastName(), this.lastName);
        page.writeText(page.getEmail(), this.email);
        page.writeText(page.getPassword(), this.password);
    }

    @And("^On Registration page click on button (.+)$")
    public void onRegistrationPageClickOnButtonCreateAccount(String button) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (button) {
            case "Create Account":
                page.click(page.getSubmitBtn());
        }
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^Yourdetails Page is opened$")
    public void yourdetailsPageIsOpened() {
        asserts.assertYourdetailsPageIsOpened(this.firstName, this.lastName, this.email, this.password);
    }
}