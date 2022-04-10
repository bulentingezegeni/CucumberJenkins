package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.UserManagementPage;
import utilities.Driver;

public class UserCreationStepdefs {

    CommonPageElements commonPageElements = new CommonPageElements();
    UserManagementPage userManagementPage = new UserManagementPage();

    @Given("admin clicks on user management")
    public void admin_clicks_on_user_management() {
        Driver.waitAndClick(commonPageElements.administrationDropdown);
        Driver.waitAndClick(commonPageElements.userManagementButton);
    }
    @Given("admin clicks on create a new user button")
    public void admin_clicks_on_create_a_new_user_button() {
        Driver.waitAndClick(userManagementPage.createNewUserButton);
    }
    @Given("admin enters {string} for login")
    public void admin_enters_for_login(String username) {
        Driver.waitAndSendText(userManagementPage.loginId,username);
    }
    @Given("admin enters {string} for firstname and {string} for lastname")
    public void admin_enters_for_firstname_and_for_lastname(String firstname, String lastname) {
        Driver.waitAndSendText(userManagementPage.firstName,firstname);
        Driver.waitAndSendText(userManagementPage.lastName,lastname);
    }
    @Given("admin enters {string} for email")
    public void admin_enters_for_email(String email) {
        Driver.waitAndSendText(userManagementPage.email,email);
    }
    @Given("admin selects language")
    public void admin_selects_language() {
        Driver.selectByIndex(userManagementPage.language,0);
    }
    @Given("admin selects profile")
    public void admin_selects_profile() {
        Driver.selectByIndex(userManagementPage.profiles,3);
    }
    @Given("admin clicks save button")
    public void admin_clicks_save_button() {
        Driver.wait(2);
        Driver.waitAndClick(userManagementPage.saveButton);
    }


}
