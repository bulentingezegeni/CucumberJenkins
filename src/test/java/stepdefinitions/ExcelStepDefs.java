package stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.CommonPageElements;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.ReusableMethods;
import java.util.List;
import java.util.Map;

public class ExcelStepDefs {

    // Excel util will be used for reusable excel methods
    // we will use this for setups and getting the data from excel
    ExcelUtil excelUtil;

    // testData will be used to store the Excel data
    List<Map<String, String>> testData;

    // LoginPage object to access the LoginPage elements
    LoginPage loginPage = new LoginPage();

    //to access the CommonPageElements elements
    CommonPageElements commonPageElements = new CommonPageElements();

    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("gmi_login_url"));
//        loginPage = new LoginPage();
//        commonPageElements = new CommonPageElements();
        ReusableMethods.waitFor(1);
        loginPage.loginDropdown.click();
        ReusableMethods.waitFor(1);;
        try{
            loginPage.signOut.click();
            ReusableMethods.waitFor(1);
            loginPage.loginDropdown.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
//            System.out.println("Sign out link is not exist");
        }
        loginPage.signInButton.click();
    }

    @Given("user login with excel as {string}")
    public void user_login_with_excel_as(String string) throws InterruptedException {
        // path of Excel sheet
        String path ="./src/test/resources/testdata/mysmoketestdata.xlsx";
        String sheetName = string+"_login_info";
        // admin_login_info = string+"_login_info";
        // employee_login_info
        // customer_login_info

        excelUtil = new ExcelUtil(path,sheetName);
        testData= excelUtil.getDataList();
        System.out.println(testData);

        // We are Using loop to get the credentials as map. When we can get value if we call the key
        for (Map<String,String> eachData : testData){
            setUp();
            loginPage.username.sendKeys(eachData.get("username"));
            loginPage.password.sendKeys(eachData.get("password"));
            loginPage.loginButton.click();
            // Assert if login is successful
            ReusableMethods.waitFor(1);
            Assert.assertTrue(commonPageElements.myOperations.isDisplayed());
            //ReusableMethods.getScreenshot("profiles"); we can take screenshot like this after every iteration
                                // otherwise we will have only one screenshot when loop finishes as the next step
        }

    }
}