package pageObjects;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By email = By.id("register_username");
    private final By password = By.id("password");
    private final By submitBtn = By.id("submit-btn");

    public By getFirstName() {
        return firstName;
    }

    public By getLastName() {
        return lastName;
    }

    public By getEmail() {
        return email;
    }

    public By getPassword() {
        return password;
    }

    public By getSubmitBtn() {
        return submitBtn;
    }

}
