package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegistrationStepDefs {

    RegistrationPage registrationPage= new RegistrationPage();
    Faker faker = new Faker();

    @Given("user is on the registration page")
    public void user_is_on_the_registration_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmiBank_registration_url"));
    }
    @Given("user enters ssn number as {string}")
    public void user_enters_ssn_number_as(String ssn) {
        //registrationPage.ssnTextbox.sendKeys(ssn);
//        NOTE: there is a reusable method in the Driver class.
//        We can use it for sending the text to the element
//         It will wait when needed as well
        //ssn = faker.idNumber().ssnValid();
        Driver.waitAndSendText(registrationPage.ssnTextbox,ssn);
    }
    @Given("user enters firstname as {string} and lastname as {string}")
    public void user_enters_firstname_as_and_lastname_as(String firstname, String lastname) {
//        registrationPage.firstnameTextbox.sendKeys(firstname);
//        registrationPage.lastnameTextbox.sendKeys(lastname);
        firstname=faker.name().firstName();
        lastname=faker.name().lastName();
        Driver.waitAndSendText(registrationPage.firstnameTextbox,firstname);
        Driver.waitAndSendText(registrationPage.lastnameTextbox,lastname);
    }
    @Given("user provides address {string}")
    public void user_provides_address(String address) {
        //registrationPage.addressTextbox.sendKeys(address);
        Driver.waitAndSendText(registrationPage.addressTextbox,address);
    }
    @Given("user provides phoneNumber {string}")
    public void user_provides_phone_number(String phoneNumber) {
        //registrationPage.mobilephoneTextbox.sendKeys(phoneNumber);
        Driver.waitAndSendText(registrationPage.mobilephoneTextbox,phoneNumber);
    }
    @Given("user provides username {string}")
    public void user_provides_username(String username) {
        //registrationPage.usernameTextbox.sendKeys(username);
        username=faker.name().username();
        Driver.waitAndSendText(registrationPage.usernameTextbox,username);
    }
    @Given("user provides email {string}")
    public void user_provides_email(String email) {
        //registrationPage.emailTextbox.sendKeys(email);
        email=faker.internet().emailAddress();
        Driver.waitAndSendText(registrationPage.emailTextbox,email);

    }
    @Given("user provides the firstPassword as {string} and secondPassword as {string}")
    public void user_provides_the_first_password_as_and_second_password_as(String firstPassword, String secondPassword) {
        //registrationPage.firstPasswordTextbox.sendKeys(firstPassword);
        //registrationPage.newPasswordTextbox.sendKeys(secondPassword);
        Driver.waitAndSendText(registrationPage.firstPasswordTextbox,firstPassword);
        Driver.waitAndSendText(registrationPage.newPasswordTextbox,secondPassword);
    }
    @Then("user clicks on the register button and see the success message as {string}")
    public void user_clicks_on_the_register_button_and_see_the_success_message_as(String message) {
        //registrationPage.registerButton.click();
        Driver.waitAndClick(registrationPage.registerButton);
        Driver.wait(1);
        //Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
        Assert.assertTrue(registrationPage.successMessageToastContainer.getText().contains(message));
    }


}
